package com.example.showuserdata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Model.Post
import com.example.Model.User
import com.example.adapter.UserAdapter
import com.example.viewmodel.UserViewModel
import java.util.*

class MainActivity : AppCompatActivity() {
    private var userViewModel: UserViewModel? = null
    var adapter: UserAdapter? = null
    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<RecyclerView?>(R.id.recycler_view)
        recyclerView!!.setLayoutManager(LinearLayoutManager(this))
        recyclerView!!.setHasFixedSize(true)
        adapter = UserAdapter()
        recyclerView!!.setAdapter(adapter)
        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        getData()
    }

    private fun getData() {
        userViewModel!!.getAllUsers()!!.observe(this, Observer { userList: MutableList<User?>? -> adapter!!.setUserList(userList as ArrayList<User?>?) })
        userViewModel!!.getAllPost()!!.observe(this, Observer { postList: MutableList<Post?>? -> adapter!!.setPostList(postList as ArrayList<Post?>?) })
    }
}