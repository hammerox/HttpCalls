package com.hammerox.retrofit.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Mauricio on 13-Dec-16.
 */

public interface ApiInterface {

    @GET("?action=person.signIn")
    public Call<SignIn> signIn(@Query("username") String username,
                               @Query("password") String password);
}
