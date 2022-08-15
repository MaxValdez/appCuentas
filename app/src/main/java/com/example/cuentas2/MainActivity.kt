package com.example.cuentas2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.calculos.Calculos
import com.example.cuentas2.databinding.ActivityMainBinding
import com.example.data.EstadoApp
import com.example.data.EstadoCuentas
import com.example.data.FunConsultas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var tomarSaldo = FunConsultas()
    var onOpen: Double? = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var aux = 0.0
        var nuevo = 0.0
        var monitor: Double =
            binding.tvMonitor.text.toString().toDouble()//el monitor esta inicializado en 0.0
        var calculo = Calculos()
        var hoy = LocalDate.now().toString()
        // hoy = hoy.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        /*DateTimeFormatter formatador =
        DateTimeFormatter.ofPattern("dd/MM/yyyy")
        hoy.format(formatador)*/

        //Comprobamos si es la primera vez que se usa la app
        lifecycleScope.launch(Dispatchers.IO) {

            onOpen = EstadoApp.room.estadoDao().getSaldo(1)

            aux = if (onOpen == null) {
                0.0
            } else {

                EstadoApp.room.estadoDao().getSaldo(1)

            }
            binding.tvMonitor.text = "El Saldo actual es : $aux"
        }
        var detalles = ""

        binding.btnSumar.setOnClickListener {

            nuevo = binding.etNumeros.text.toString().toDouble()//Dato del EditText
            monitor = calculo.sumar(aux, nuevo)//Dato para el monitor
            aux = monitor
            detalles = binding.etDetalle.text.toString()
            binding.tvMonitor.text = "El Saldo actual es : $monitor"

            lifecycleScope.launch(Dispatchers.IO) {

                EstadoApp.room.estadoDao()
                    .insertarSaldo(EstadoCuentas(1, monitor, "SALDO", hoy, 0))//Actualizamos saldo
                EstadoApp.room.estadoDao()
                    .insertarSaldo(EstadoCuentas(0,nuevo,detalles,hoy,0))//Ingresamos nuevo saldo
            }

        }

        binding.btnRestar.setOnClickListener {
            nuevo = binding.etNumeros.text.toString().toDouble()//Dato del EditText
            monitor = calculo.restar(aux, nuevo)//Dato para el monitor
            aux = monitor
            detalles = binding.etDetalle.text.toString()
            binding.tvMonitor.text = "El Saldo actual es : $monitor"
            lifecycleScope.launch(Dispatchers.IO) {
                detalles = binding.etDetalle.text.toString()
                EstadoApp.room.estadoDao().insertarSaldo(EstadoCuentas(1, monitor, "SALDO", hoy, 1))
                EstadoApp.room.estadoDao().insertarSaldo(EstadoCuentas(0, nuevo, detalles, hoy, 1))

            }
        }

        binding.btnMontos.setOnClickListener {
            val proximaActividad = Intent(this, DetalleSaldos::class.java)
            startActivity(proximaActividad)
        }
    }
}
