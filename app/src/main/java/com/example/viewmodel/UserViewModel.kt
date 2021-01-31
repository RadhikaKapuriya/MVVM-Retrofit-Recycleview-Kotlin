package com.example.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.Model.Post
import com.example.Model.User
import com.example.repository.UserRepository

class UserViewModel(application: Application) : AndroidViewModel(application) {
    var repository: UserRepository?
    fun getAllUsers(): LiveData<MutableList<User?>?>? {
        return repository!!.getUsers()
    }

    fun getAllPost(): LiveData<MutableList<Post?>?>? {
        return repository!!.getPost()
    }

    init {
        repository = UserRepository(application)
    }
}