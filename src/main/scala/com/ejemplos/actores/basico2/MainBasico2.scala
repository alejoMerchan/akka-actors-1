package com.ejemplos.actores.basico2

import akka.actor.{ActorSystem, Props}
import com.ejemplos.actores.basico2.ActorPing.Ping

/**
  * Created by ALEJANDRO on 04/10/2016.
  *
  * Ejemplo de envio de mensajes entre actores.
  *
  *
  */
object MainBasico2 extends App{

  val system = ActorSystem("MySystem")

  val actorPing  = system.actorOf(Props[ActorPing], "actorPing")

  actorPing ! Ping("Ping")

}
