package com.example.users.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.users.databinding.UserBinding
import com.example.users.network.UserDto

class UserAdapter(val users: List<UserDto>) : RecyclerView.Adapter<UserAdapter.RVHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVHolder {
        return RVHolder(UserBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RVHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount() = users.size

    class RVHolder(private val binding: UserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserDto) {
            binding.user = user
        }
    }
}