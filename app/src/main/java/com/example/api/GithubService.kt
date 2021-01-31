package com.example.api

import com.example.Model.Post
import com.example.Model.User
import retrofit2.Call
import retrofit2.http.GET

interface GithubService {
    @GET("users")
    open fun getUsers(): Call<MutableList<User?>?>?

    @GET("posts")
    open fun getPosts(): Call<MutableList<Post?>?>?
}