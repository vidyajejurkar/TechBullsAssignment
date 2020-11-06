package com.vidya.techbullsassignment.api;


import com.vidya.techbullsassignment.model.SearchResponse;
import com.vidya.techbullsassignment.model.ShowDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShowApi
{
    @GET("?")
    Call<SearchResponse> getSearchResults(@Query("s") String title, @Query("page") int pages, @Query("apikey") String apikey);
    @GET("?")
    Call<ShowDetails> getShowDetails(@Query("i") String imdbId, @Query("apikey") String apiKey);
}
