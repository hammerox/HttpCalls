package com.hammerox.retrofit;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hammerox.retrofit.retrofit.ApiInterface;
import com.hammerox.retrofit.retrofit.SignIn;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "https://inevent.us/api/";

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
        getTextFromViews();

    }


    public void retrofit(View view) {
        mRetrofitTextView.setText("Loading...");
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
                mRetrofitTextView.setText("Error");
            }
        });
    }


    public void getTextFromViews() {
        mLogin = mLoginView.getText().toString();
        mPassword = mPasswordView.getText().toString();
    }

}
