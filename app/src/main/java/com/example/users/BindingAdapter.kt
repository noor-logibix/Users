package com.example.users

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.users.network.UserDto
import com.example.users.users.UserAdapter

@BindingAdapter("setDataSet", requireAll = true)
fun setDataSet(recyclerView: RecyclerView, data: List<UserDto>?) {
    recyclerView.adapter = data?.let { UserAdapter(it) }
}