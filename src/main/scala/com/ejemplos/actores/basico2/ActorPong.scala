package com.ejemplos.actores.basico2

import akka.actor.Actor
import akka.actor.Actor.Receive
import com.ejemplos.actores.basico2.ActorPing.Ping
import com.ejemplos.actores.basico2.ActorPong.Pong

/**
  * Created by ALEJANDRO on 04/10/2016.
  */
object ActorPong {


  case class Pong(mensaje:String)

}

class ActorPong extends Actor {
  override def receive: Receive = {

    case Pong(mensaje) =>
      println(mensaje)

      /**
        * Se hace referencia al actor que envio el mensaje Pong mediante el metodo sender()
        * y se le envia un mensaje de respuesta
        */
      sender() ! Ping("Ping")

  }
}
