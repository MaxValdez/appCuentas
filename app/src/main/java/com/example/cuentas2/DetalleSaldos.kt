package com.example.cuentas2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.data.EstadoApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetalleSaldos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_saldos)
        val recyclerView = findViewById<RecyclerView>(R.id.rvDetalle)
        var adapter = CustomAdapter(arrayOf("1", "2"), arrayOf(0.0), arrayOf(""), arrayOf(0))
        var aux: Array<String>
        var auxDouble: Array<Double>
        var auxFecha: Array<String>
        var auxColor:Array<Int>
        lifecycleScope.launch(Dispatchers.IO) {//tomamos los datalles para el recyclerView (mostrar saldos)
            aux = EstadoApp.room.estadoDao().tomarEstados()
            auxDouble = EstadoApp.room.estadoDao().getSaldos()
            auxFecha = EstadoApp.room.estadoDao().tomarFecha()
            auxColor = EstadoApp.room.estadoDao().tomarColor()
            adapter = CustomAdapter(aux, auxDouble,auxFecha,auxColor)

            recyclerView.adapter = adapter
        }


        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.adapter = adapter

    }


}