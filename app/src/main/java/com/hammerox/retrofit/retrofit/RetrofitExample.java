package com.hammerox.retrofit.retrofit;

import android.widget.TextView;

import com.hammerox.retrofit.MainActivity;
import com.hammerox.retrofit.utils.SignIn;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mauricio on 14-Dec-16.
 */

public class RetrofitExample {

    public static void call(final TextView textView, String login, String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(ApiInterface.class)
                .signIn(login, password)
                .enqueue(new Callback<SignIn>() {

                    @Override
                    public void onResponse(Call<SignIn> call, Response<SignIn> response) {
                        String token = response.body().getData().get(0).getTokenID();
                        textView.setText(token);
                    }

                    @Override
                    public void onFailure(Call<SignIn> call, Throwable t) {
                        textView.setText(MainActivity.ERROR);
                    }

                });
    }
}
