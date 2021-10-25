package com.skatincorp.le

data class Pregunta(
    val question: String,
    val opciones: List<String>,
    val opcioncorrecta: Int,
    var opcionselecionada: Int = -1
    )
