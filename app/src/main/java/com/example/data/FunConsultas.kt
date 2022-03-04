package com.example.data

import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FunConsultas (){

    fun tomarSaldo():Double{
        var saldo = -1.0
        GlobalScope.launch(Dispatchers.IO) {
             saldo = EstadoApp.room.estadoDao().getSaldo(1)
        }

        return saldo
    }
}