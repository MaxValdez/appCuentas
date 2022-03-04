package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EstadoCuentas(
                         @PrimaryKey(autoGenerate = true)
                         val id:Int,
                         val estado:Double,
                         val leyenda:String,
                         val fecha:String,
                         val color:Int
) {
}