package com.ejemplos.actores.basico2

import akka.actor.{Actor, Props}
import akka.actor.Actor.Receive
import com.ejemplos.actores.basico2.ActorPing.Ping
import com.ejemplos.actores.basico2.ActorPong.Pong

/**
  * Created by ALEJANDRO on 04/10/2016.
  */
object ActorPing {

  case class Ping(mensaje:String)

}

class ActorPing extends Actor {
  /**
    * se importa el contexto de actores.
    */
  import context._

  val actorPong  = actorOf(Props[ActorPong], "actorPong")
  override def receive: Receive = {

    case Ping(mensaje) =>
      println(mensaje)

    /**
      * Se hace referencia al actor que envio el mensaje Ping mediante el metodo sender()
      * y se le envia un mensaje de respuesta
      */

    actorPong  ! Pong("Pong pruba")

  }

}
