package com.example.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [EstadoCuentas::class],
    version = 2

)
abstract class EstadoDb: RoomDatabase() {

    abstract fun estadoDao(): EstadoDao
}