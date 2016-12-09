package com.ejemplos.actores.basico3

import akka.actor.{Actor, Props}
import akka.actor.Actor.Receive
import com.ejemplos.actores.basico3.ExpedirSolicitudes.{Expedir, ProcesarCotizacionResponse, ProcesarSolicitudesRespose}
import com.ejemplos.actores.basico3.ProcesadorSolicitudes.Solicitudes
import com.ejemplos.actores.basico3.ProcesarCotizaciones.Cotizaciones

/**
  * Created by ALEJANDRO on 09/12/2016.
  */
object ExpedirSolicitudes {



  case class ProcesarSolicitudesRespose(mensaje:String)
  case class ProcesarCotizacionResponse(mensaje:String)
  case class Expedir(mensaje:String)

}

class ExpedirSolicitudes extends Actor {

  import context._

  val actorProcesarSolicitudes  = actorOf(Props[ProcesadorSolicitudes], "procesar-solicitudes")

  val actorProcesarCotizaiones = actorOf(Props[ProcesarCotizaciones], "procesar-cotizaciones")

   def receive: Receive = {

     case msj1:Expedir =>
       println("--- comenzando el proceso de: " + msj1.mensaje)
       actorProcesarSolicitudes ! Solicitudes("procesar")
       actorProcesarCotizaiones ! Cotizaciones("procesar")

     case msj2:ProcesarSolicitudesRespose => println(msj2.mensaje)

     case msj3:ProcesarCotizacionResponse => println(msj3.mensaje)

   }

}
