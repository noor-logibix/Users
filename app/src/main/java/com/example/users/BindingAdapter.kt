package com.example.users

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.users.network.UserDto
import com.example.users.users.UserAdapter

@BindingAdapter("userList")
fun bindingRecyclerView(recyclerView: RecyclerView, data: List<UserDto>?) {
    val adapter = recyclerView.adapter as UserAdapter
    adapter.submitList(data)
}