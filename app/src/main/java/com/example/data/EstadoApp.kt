package com.example.data

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class EstadoApp:Application() {
   /* val MIGRATION_1_2: Migration = object : Migration(1,2){
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE EstadoCuentas ADD COLUMN fecha TEXT DEFAULT ''")
        }


    }*/
    companion object{lateinit var room:EstadoDb}
    override fun onCreate() {
    super.onCreate()
     room = Room
         .databaseBuilder(this,EstadoDb::class.java,"estado")
         .build()

    }
}