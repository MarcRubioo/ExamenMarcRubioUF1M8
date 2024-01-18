package com.marcr.examenmarcrubiouf1m8.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface Dao_User {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAlum(alum: User)

    @Update
    suspend fun updateAlum(alum: User)

    @Delete
    suspend fun deleteAlum(alum: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllAlumns(): LiveData<List<User>>

}