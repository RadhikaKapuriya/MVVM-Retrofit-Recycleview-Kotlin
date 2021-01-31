package com.example.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.Model.Post
import com.example.Model.User
import com.example.api.GithubService
import com.example.api.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class UserRepository(private val application: Application?) {
    private var userArrayList: ArrayList<User?>? = ArrayList()
    var mutableLiveData: MutableLiveData<MutableList<User?>?>? = MutableLiveData()
    private var PostArrayList: ArrayList<Post?>? = ArrayList()
    var mutableLiveDataPost: MutableLiveData<MutableList<Post?>?>? = MutableLiveData()
    var apiInterface: GithubService? = null
    fun getPost(): MutableLiveData<MutableList<Post?>?>? {
        apiInterface = RestClient.getClient()!!.create(GithubService::class.java)
        val call = apiInterface!!.getPosts()
        call!!.enqueue(object : Callback<MutableList<Post?>?> {
            override fun onResponse(call: Call<MutableList<Post?>?>?, response: Response<MutableList<Post?>?>?) {
                if (response!!.body() != null) {
                    PostArrayList = response!!.body() as ArrayList<Post?>?
                    mutableLiveDataPost!!.setValue(PostArrayList)
                }
            }

            override fun onFailure(call: Call<MutableList<Post?>?>?, t: Throwable?) {}
        })
        return mutableLiveDataPost
    }

    fun getUsers(): MutableLiveData<MutableList<User?>?>? {
        apiInterface = RestClient.getClient()!!.create(GithubService::class.java)
        val call = apiInterface!!.getUsers()
        call!!.enqueue(object : Callback<MutableList<User?>?> {
            override fun onResponse(call: Call<MutableList<User?>?>?, response: Response<MutableList<User?>?>?) {
                if (response!!.body() != null) {
                    userArrayList = response.body() as ArrayList<User?>?
                    mutableLiveData!!.setValue(userArrayList)
                }
            }

            override fun onFailure(call: Call<MutableList<User?>?>?, t: Throwable?) {}
        })
        return mutableLiveData
    }

}