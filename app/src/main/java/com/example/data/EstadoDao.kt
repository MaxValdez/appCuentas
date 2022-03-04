package com.example.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EstadoDao {
    @Query("SELECT estado FROM EstadoCuentas WHERE id = :id")
   suspend fun getSaldo(id: Int): Double

    @Query("SELECT estado FROM EstadoCuentas where id > 1 ")
    suspend fun getSaldos(): Array<Double>

    @Query("SELECT fecha FROM EstadoCuentas where id > 1 ")
    suspend fun tomarFecha(): Array<String>

   @Query("Select * from estadocuentas where id = :id")
   suspend fun tomarDetalle(id:Int):EstadoCuentas

   @Query("select id from estadocuentas")
   suspend fun tomarId():Int

  @Query("select leyenda from estadocuentas where id > 1")
   suspend fun tomarEstados():Array<String>

    @Query("select color from estadocuentas")
    suspend fun tomarColor():Array<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarSaldo(saldo:EstadoCuentas)

    @Insert
    suspend fun insertarSaldoNormal(saldo:EstadoCuentas)

}