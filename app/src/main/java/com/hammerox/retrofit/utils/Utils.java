package com.hammerox.retrofit.utils;

import android.net.Uri;

import com.hammerox.retrofit.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mauricio on 14-Dec-16.
 */

public class Utils {

    public static String buildUri(String login, String password) {
        return Uri.parse(MainActivity.BASE_URL).buildUpon()
                  .appendQueryParameter("action", "person.signIn")
                  .appendQueryParameter("username", login)
                  .appendQueryParameter("password", password)
                  .build()
                  .toString();
    }


    public static String getTokenFromJson(String jsonString) {
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
