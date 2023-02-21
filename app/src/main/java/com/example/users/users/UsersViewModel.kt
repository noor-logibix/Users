package com.example.users.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.users.network.MarsApi
import com.example.users.network.UserDto
import kotlinx.coroutines.launch

class UsersViewModel : ViewModel() {

    private val _users = MutableLiveData<List<UserDto>>()

    val users: LiveData<List<UserDto>>
        get() = _users

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            try {
                _users.value = MarsApi.retrofitService.getProperties()
            } catch (e: Exception) {
                _users.value = ArrayList()
            }
        }
    }
}