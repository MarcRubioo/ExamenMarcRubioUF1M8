package com.marcr.examenmarcrubiouf1m8.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class database: RoomDatabase() {

    abstract fun userDao(): Dao_User

    companion object {
        @Volatile
        private var INSTANCE: database? = null

        fun getDatabase(context: Context): database {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            } else {
                return INSTANCE!!
            }
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): database {
            return Room.databaseBuilder(
                context.applicationContext,
                database::class.java,
                "user_table"
            )
                .build()
        }
    }
}