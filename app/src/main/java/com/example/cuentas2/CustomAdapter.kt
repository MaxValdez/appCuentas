package com.example.cuentas2


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class CustomAdapter ( saldos:Array<String>,montos:Array<Double>,fecha:Array<String>,color:Array<Int>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    val titles = saldos
    val montos = montos
    val fechas = fecha
    var color = color
    var fondo=""


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_detalles, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(color[position+1] == 1){
            fondo = "#FD0000"

        }else{

            fondo = "#3AFD00"
        }
        holder.itemText.text = titles[position]
        holder.itemTextMonto.text = montos[position].toString()
        holder.itemTextFecha.text = fechas[position]
        holder.itemFondo.setBackgroundColor(Color.parseColor(fondo))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemText: TextView
        var itemTextMonto: TextView
        var itemTextFecha: TextView
        var itemFondo:CardView

        init {


            itemText = itemView.findViewById(R.id.tvDetalleCard)
            itemTextMonto = itemView.findViewById(R.id.tvDetalleMonto)
            itemTextFecha = itemView.findViewById(R.id.tvFecha)
            //prueba
            itemFondo = itemView.findViewById(R.id.cvDetalle)
        }
    }


}