package com.marcr.examenmarcrubiouf1m8.alumnes

import android.content.Context
import androidx.lifecycle.ViewModel
import com.marcr.examenmarcrubiouf1m8.data.User
import com.marcr.examenmarcrubiouf1m8.data.repository

class ViewModelAlumnes: ViewModel() {
    fun afegirAlumne(context: Context, name:String, group: String,note:Int, ) {
        var user = User(null, name, group,note)
        repository.addUser(user,context)
    }
}