package com.example.users.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.users.databinding.FragmentUserBinding

class UsersFragment : Fragment() {
    private val viewModel: UsersViewModel by lazy {
        ViewModelProvider(this).get(UsersViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUserBinding.inflate(inflater)
        binding.viewModel = viewModel
        return binding.root
    }

}