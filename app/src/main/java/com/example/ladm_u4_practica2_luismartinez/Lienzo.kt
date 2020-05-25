package com.example.ladm_u4_practica2_luismartinez

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Lienzo(p: MainActivity) : View(p) {
    var puntero = p
    var kirby =
        FiguraGeometrica(BitmapFactory.decodeResource(resources, R.drawable.der ), 100, 200)

    var escenario =
    FiguraGeometrica(BitmapFactory.decodeResource(resources, R.drawable.fondo2), 0, 0)
    var fondo =FiguraGeometrica()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()
        fondo.pintar(canvas, paint)
        escenario.pintar(canvas, paint)
        kirby.pintar(canvas, paint)

        invalidate()

    }

    fun moverDerecha() {
        kirby.caminarDerecha()

    }

    fun moverIzq() {
        kirby.caminarIzquierda()

    }
    fun proximidadOn(){
        escenario=FiguraGeometrica()
        fondo=FiguraGeometrica(BitmapFactory.decodeResource(resources, R.drawable.fondo), 0, 0)

    }
    fun proximidadOff(){
        escenario=FiguraGeometrica(BitmapFactory.decodeResource(resources, R.drawable.fondo2), 0, 0)
        fondo=FiguraGeometrica()

    }




}//class
