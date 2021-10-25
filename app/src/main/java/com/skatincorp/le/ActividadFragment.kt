package com.skatincorp.le

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class ActividadFragment : Fragment(), View.OnClickListener {

    private val preguntas = listOf(Preguntas.preguntas1,Preguntas.preguntas2,Preguntas.preguntas3).random()
    private var currentoption = -1
    private lateinit var textpregunta: TextView
    private lateinit var  radiobutton1: RadioButton
    private lateinit var  radiobutton2: RadioButton
    private lateinit var  radiobutton3: RadioButton
    private var currentpos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_actividad, container, false)
        textpregunta = view.findViewById(R.id.preguntatext)
        radiobutton1 = view.findViewById(R.id.option1)
        radiobutton2 = view.findViewById(R.id.opcion2)
        radiobutton3 = view.findViewById(R.id.opcion3)
        val button1 = view.findViewById<Button>(R.id.btn_next)
        radiobutton1.setOnClickListener(this)
        radiobutton2.setOnClickListener(this)
        radiobutton3.setOnClickListener(this)
        button1.setOnClickListener(this)
        Llenarpregunta(currentpos)
        return view
    }

    private fun Llenarpregunta(pos:Int){
        val pregunta = preguntas[pos]
        with(pregunta){
            textpregunta.text = question
            radiobutton1.text = opciones[0]
            radiobutton2.text = opciones[1]
            radiobutton3.text = opciones[2]
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id){
            R.id.option1 -> currentoption = 0
            R.id.opcion2 -> currentoption = 1
            R.id.opcion3 -> currentoption = 2
            R.id.btn_next -> if (currentoption!= -1) validarpreguntas()
        }
    }

    private fun validarpreguntas() {
        val pregunta = preguntas[currentpos]
        pregunta.opcionselecionada = currentoption
        if (currentpos<preguntas.size-1){
            currentpos++
            Llenarpregunta(currentpos)
        }else {
            var a = 0
            preguntas.forEach{
                if (it.opcioncorrecta==it.opcionselecionada)
                    a++
            }
            Toast.makeText(context, "Preguntas Correctas = $a", Toast.LENGTH_SHORT).show()
        }
    }


}