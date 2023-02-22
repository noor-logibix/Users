package com.example.users.users

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.users.network.MarsApi
import com.example.users.network.UserDto
import kotlinx.coroutines.launch

class UsersViewModel : ViewModel() {
    private val TAG = "UsersViewModel"

    private val _users = MutableLiveData<List<UserDto>>()
    val users: LiveData<List<UserDto>>
        get() = _users

    private val _txt = MutableLiveData<String>()
    val txt: LiveData<String>
        get() = _txt

    init {
        getUsers()
    }

    private fun getUsers() {
        var status = "Loading..."
        _txt.value = status
        Log.d(TAG, status)
        viewModelScope.launch {
            try {
                val result = MarsApi.retrofitService.getProperties()
                status = if (result.isEmpty()) "Success: Empty" else "Success: ${result[0].name}"
                _txt.value = status
                Log.d(TAG, status)
                _users.value = result
            } catch (e: Exception) {
                _users.value = ArrayList()
                status = "Exception ${e.message}"
                _txt.value = status
                Log.d(TAG, status)
            }
        }
    }
}