package com.hammerox.retrofit.okhttp;

import android.app.Activity;
import android.widget.TextView;

import com.hammerox.retrofit.MainActivity;
import com.hammerox.retrofit.utils.Utils;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Mauricio on 14-Dec-16.
 */

public class OkHttpExample {

    public static void call(final Activity activity, final TextView textView, String login, String password) {
        String myURL = Utils.buildUri(login, password);

        Request request = new Request.Builder()
                .url(myURL)
                .build();

        OkHttpClient client = new OkHttpClient();

        client.newCall(request).enqueue(new okhttp3.Callback() {

            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                textView.setText(MainActivity.ERROR);
            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                String json = response.body().string();
                String token = Utils.getTokenFromJson(json);

                final String text = (token != null) ? token : MainActivity.ERROR;

                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(text);
                    }
                });
            }

        });
    }
}
