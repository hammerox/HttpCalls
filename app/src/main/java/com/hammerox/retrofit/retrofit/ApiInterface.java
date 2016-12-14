package com.hammerox.retrofit.retrofit;

import com.hammerox.retrofit.utils.SignIn;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Mauricio on 13-Dec-16.
 */

public interface ApiInterface {

    @GET("?action=person.signIn")
    Call<SignIn> signIn(@Query("username") String username,
                        @Query("password") String password);
}
