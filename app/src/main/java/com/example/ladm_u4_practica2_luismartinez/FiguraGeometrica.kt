package com.example.ladm_u4_practica2_luismartinez

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent

class FiguraGeometrica() {
    var x = 0f
    var y = 0f
    var tipo = 1 //1 circulo 2 rectangulo // 3 bitmap //4 text
    var radio = 0f
    var ancho = 0f
    var alto = 0f
    var incX = 10
    var incY = 5
    var bitmap: Bitmap? = null


    constructor(x: Int, y: Int, radio: Int) : this() {
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.radio = radio.toFloat()
        //////////////////////////////////////////////////
        ancho = this.radio * 2
        alto = ancho
    }

    constructor(x: Int, y: Int, ancho: Int, alto: Int) : this() {
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.ancho = ancho.toFloat()
        this.alto = alto.toFloat()
        tipo = 2
    }

    constructor(imagen: Bitmap, x: Int, y: Int) : this() {
        bitmap = imagen
        this.x = x.toFloat()
        this.y = y.toFloat()
        ancho = bitmap!!.width.toFloat()
        alto = bitmap!!.height.toFloat()
        tipo = 3

    }

    fun pintar(c: Canvas, p: Paint) {
        when (tipo) {
            1 -> {
                //////////////////////////////////////////////////
                c.drawCircle(x + radio, y + radio, radio, p)
            }
            2 -> {
                c.drawRect(x, y, x + ancho, y + alto, p)
            }

            3 -> {
                c.drawBitmap(bitmap!!, x, y, p)
            }
        }
    }


    fun estaEnArea(posX: Float, posY: Float): Boolean {
        if (posX >= x && posX <= x + ancho) {
            if (posY >= y && posY <= y + alto) {
                return true
            }
        }
        return false
    }

    fun caminarDerecha(){
        x+=incX

        if(x>=800f){
            x=0f
        }//
    }
    fun caminarIzquierda(){
        x-=incX
        if(x<=-100){
            x=800f
        }//
    }



}