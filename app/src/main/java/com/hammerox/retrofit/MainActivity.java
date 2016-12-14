package com.hammerox.retrofit;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mLoginView;
    EditText mPasswordView;
    TextView mAsyncTaskTextView;
    TextView mOkHttpTextView;
    TextView mRetrofitTextView;

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

    }


    public void okhttp(View view) {

    }


    public void retrofit(View view) {

    }

}
