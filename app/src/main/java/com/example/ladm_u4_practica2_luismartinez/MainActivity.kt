package com.example.ladm_u4_practica2_luismartinez

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity(), SensorEventListener {
    var lienzo  : Lienzo ?= null
    lateinit var sensorManager:SensorManager
    lateinit var sensorManagerProx:SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lienzo = Lienzo(this)
        setContentView(lienzo!!)
        sensorManager=getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL)


        sensorManagerProx=getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManagerProx.registerListener(this,
            sensorManagerProx.getDefaultSensor(Sensor.TYPE_PROXIMITY),SensorManager.SENSOR_DELAY_NORMAL)

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(event!!.sensor.type==Sensor.TYPE_PROXIMITY){
            if (event.values[0]==0f){
                lienzo!!.proximidadOn()

            }else{
                lienzo!!.proximidadOff()
            }
        }//if
        if (event.sensor.type==Sensor.TYPE_ACCELEROMETER){
            setTitle("X: "+ lienzo!!.kirby.x)
            if(event.values[0]<0){
                lienzo!!.moverDerecha()

            }
            if(event.values[0]>0){
                lienzo!!.moverIzq()
            }

        }//if
    }
}
