package com.ejemplos.actores.basico3

import akka.actor.Actor
import akka.actor.Actor.Receive
import com.ejemplos.actores.basico3.ExpedirSolicitudes.ProcesarCotizacionResponse
import com.ejemplos.actores.basico3.ProcesarCotizaciones.Cotizaciones

/**
  * Created by ALEJANDRO on 09/12/2016.
  */
object ProcesarCotizaciones {

  case class Cotizaciones(msg:String)

}


class ProcesarCotizaciones extends Actor {

   def receive: Receive = {

     case msj:Cotizaciones =>
       (1 to 10000).map{
         number =>
           Thread.sleep(100)
           println("procesando cotizacion: " + number)
       }
       sender() ! ProcesarCotizacionResponse("cotizadas")

   }

}
