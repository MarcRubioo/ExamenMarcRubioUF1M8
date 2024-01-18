package com.marcr.examenmarcrubiouf1m8.data

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class repository {
    companion object {


        var UserDatabase: database? = null

        var user: LiveData<List<User>>? = null

        fun initializeDB(context: Context): database {
            return database.getDatabase(context)
        }

        fun addUser(user: User, context: Context) {
            UserDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                UserDatabase!!.userDao().addAlum(user)
            }
        }

        fun deleteUser(user: User, context: Context) {
            UserDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                UserDatabase!!.userDao().deleteAlum(user)
            }
        }

        fun updateUser(user: User, context: Context) {
            UserDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                UserDatabase!!.userDao().updateAlum(user)
            }
        }

        fun selectUser(context: Context): LiveData<List<User>> {
            UserDatabase = initializeDB(context)

            return UserDatabase!!.userDao().readAllAlumns()
        }

        fun selectUserAprobat(context: Context): LiveData<List<User>> {
            UserDatabase = initializeDB(context)

            return UserDatabase!!.userDao().readAllAlumnsAprobats()
        }

        fun selectUserSuspesos(context: Context): LiveData<List<User>> {
            UserDatabase = initializeDB(context)

            return UserDatabase!!.userDao().readAllAlumnsSuspesos()
        }
    }
}