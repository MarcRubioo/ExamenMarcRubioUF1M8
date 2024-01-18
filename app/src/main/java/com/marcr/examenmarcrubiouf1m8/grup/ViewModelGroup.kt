package com.marcr.examenmarcrubiouf1m8.grup

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.marcr.examenmarcrubiouf1m8.data.User
import com.marcr.examenmarcrubiouf1m8.data.repository

class ViewModelGroup: ViewModel() {
    lateinit var  users: LiveData<List<User>>
    fun getUser (context: Context){
        users = repository.selectUser(context)
    }
}