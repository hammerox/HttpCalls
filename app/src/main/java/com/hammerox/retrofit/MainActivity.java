package com.hammerox.retrofit;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hammerox.retrofit.retrofit.ApiInterface;
import com.hammerox.retrofit.retrofit.SignIn;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public final static String BASE_URL = "https://inevent.us/api/";
    private final static String LOADING = "Loading...";
    private final static String ERROR = "Error!";

    EditText mLoginView;
    EditText mPasswordView;
    TextView mAsyncTaskTextView;
    TextView mOkHttpTextView;
    TextView mRetrofitTextView;

    String mLogin;
    String mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginView = (EditText) findViewById(R.id.login);
        mPasswordView = (EditText) findViewById(R.id.password);
        mAsyncTaskTextView = (TextView) findViewById(R.id.text_asynctask);
        mOkHttpTextView = (TextView) findViewById(R.id.text_okhttp);
        mRetrofitTextView = (TextView) findViewById(R.id.text_retrofit);
    }


    public void asynctask(View view) {
        getTextFromViews();

    }


    public void okhttp(View view) {
        mOkHttpTextView.setText(LOADING);
        getTextFromViews();

        Uri url = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter("action", "person.signIn")
                .appendQueryParameter("username", mLogin)
                .appendQueryParameter("password", mPassword).build();

        Request request = new Request.Builder()
                .url(url.toString())
                .build();

        OkHttpClient client = new OkHttpClient();


        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                mOkHttpTextView.setText(ERROR);
            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                String json = response.body().string();
                String token = getTokenFromJson(json);
                final String text = (token != null) ? token : ERROR;

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mOkHttpTextView.setText(text);
                    }
                });

            }
        });
    }


    public void retrofit(View view) {
        mRetrofitTextView.setText(LOADING);
        getTextFromViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(ApiInterface.class).signIn(mLogin, mPassword).enqueue(new Callback<SignIn>() {
            @Override
            public void onResponse(Call<SignIn> call, Response<SignIn> response) {
                String token = response.body().getData().get(0).getTokenID();
                mRetrofitTextView.setText(token);
            }

            @Override
            public void onFailure(Call<SignIn> call, Throwable t) {
                mRetrofitTextView.setText(ERROR);
            }
        });
    }


    public void getTextFromViews() {
        mLogin = mLoginView.getText().toString();
        mPassword = mPasswordView.getText().toString();
    }

    private String getTokenFromJson(String jsonString) {
        String token;
        try {
            JSONObject json = new JSONObject(jsonString);
            JSONObject person = json.getJSONArray("data").getJSONObject(0);
            token = person.getString("tokenID");
        } catch (JSONException e) {
            e.printStackTrace();
            token = null;
        }
        return token;
    }

}
