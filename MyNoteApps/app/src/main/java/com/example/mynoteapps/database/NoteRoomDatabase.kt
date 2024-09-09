package com.example.mynoteapps.database

import android.app.Application
import android.content.Context
import androidx.room.Database
// import room
import androidx.room.Room
import androidx.room.RoomDatabase

class NoteRoomDatabase {
    @Database(entities = [Note::class], version = 1)
    abstract class NoteRoomDatabase : RoomDatabase() {
        abstract fun noteDao(): NoteDao
    }

    companion object {
        @Volatile
        private var INSTANCE: NoteRoomDatabase? = null

        @JvmStatic
        fun getDatabase(application: Application): NoteRoomDatabase {
            if (INSTANCE == null) {
                synchronized(NoteRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        application.applicationContext,
                        NoteRoomDatabase::class.java,
                        "note_database"
                    ).build()
                }
            }
            return INSTANCE as NoteRoomDatabase
        }
    }
}