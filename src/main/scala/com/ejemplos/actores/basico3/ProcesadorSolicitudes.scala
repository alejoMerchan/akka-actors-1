package com.ejemplos.actores.basico3

import akka.actor.Actor
import com.ejemplos.actores.basico3.ExpedirSolicitudes.ProcesarSolicitudesRespose
import com.ejemplos.actores.basico3.ProcesadorSolicitudes.Solicitudes

/**
  * Created by ALEJANDRO on 09/12/2016.
  */
object ProcesadorSolicitudes {



  case class Solicitudes(msg:String)

}

class ProcesadorSolicitudes extends Actor {

  def receive = {

    case msg: Solicitudes =>
      (1 to 10000).map {

        number =>
          Thread.sleep(300)
          println("procesando solicitud: " + number)
      }

      sender() ! ProcesarSolicitudesRespose("expedidas")

  }

}
