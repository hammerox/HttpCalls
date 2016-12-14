package com.hammerox.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hammerox.retrofit.okhttp.OkHttpExample;
import com.hammerox.retrofit.retrofit.RetrofitExample;


public class MainActivity extends AppCompatActivity {

    public final static String BASE_URL = "https://inevent.us/api/";
    public final static String LOADING = "Loading...";
    public final static String ERROR = "Error!";

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

        OkHttpExample.call(this, mOkHttpTextView, mLogin, mPassword);
    }


    public void retrofit(View view) {
        mRetrofitTextView.setText(LOADING);
        getTextFromViews();

        RetrofitExample.call(mRetrofitTextView, mLogin, mPassword);
    }


    public void getTextFromViews() {
        mLogin = mLoginView.getText().toString();
        mPassword = mPasswordView.getText().toString();
    }

}
