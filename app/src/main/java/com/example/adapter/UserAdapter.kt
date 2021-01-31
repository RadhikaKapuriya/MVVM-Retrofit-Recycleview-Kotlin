package com.example.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Model.Post
import com.example.Model.User
import com.example.showuserdata.R

import java.util.*

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder?>() {
    private var users: ArrayList<User?>? = null
    private var Posts: ArrayList<Post?>? = null
    fun setPostList(users1: ArrayList<Post?>?) {
        Posts = users1
        Log.d("setUserList123", "setPostList = " + Posts!!.size)
        notifyDataSetChanged()
    }

    fun setUserList(users1: ArrayList<User?>?) {
        users = users1
        Log.d("setUserList123", "setUserList = " + users!!.size)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.item_user, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myListData = users!!.get(position)
        Log.d("setUserList123", "getTitle = " + users!!.get(position)!!.getName())
        Log.d("setUserList123", "getTitle = " + users!!.get(position)!!.getName())
        try {
            if (Posts!!.get(position)!!.getId() === users!!.get(position)!!.getId()) {
                holder.tvname!!.setText(users!!.get(position)!!.getCompany()!!.name)
                holder.tvbody!!.setText("Body = " + Posts!!.get(position)!!.getBody())
                holder.tvtitle!!.setText("Title = " + Posts!!.get(position)!!.getTitle())
            }
        }catch (e:Exception)
        {
            
        }
    }

    override fun getItemCount(): Int {
        return if (users != null) {
            users!!.size
        } else {
            0
        }
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var tvname: TextView?
        var tvbody: TextView?
        var tvtitle: TextView?

        init {
            tvname = itemView!!.findViewById<View?>(R.id.tvname) as TextView?
            tvbody = itemView!!.findViewById<View?>(R.id.tvbody) as TextView?
            tvtitle = itemView!!.findViewById<View?>(R.id.tvtitle) as TextView?
        }
    }
}