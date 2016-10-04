package com.ejemplos.actores.basico1

import akka.actor.{ActorSystem, Props}

/**
  * Created by ALEJANDRO on 03/10/2016.
  */
object MainBasico1 extends App{

  /**
    * Se crea el sistema de actores en la JVM.
    */
  val system = ActorSystem("mySystem")

  /**
    * Se crea en el sistema de actores una instancia del MyActor1 y se le llama myActor.
    * Dicha instancia puede ser llamada por su nombre en cualquier momento.
    */
  val myActor1 = system.actorOf(Props[MyActor1], "myActor")

  // se le manda un mensaje "hola mundo" al actor MyActor1.
  myActor1 ! "hola mundo"
  // se manda un mensaje "hola cualquier otra cosa" al actor MyActor1.
  myActor1 ! "hola cualquier otra cosa"

  /**
    * el envio de mensajes es totalmente asincrono y no se espera ninguna respuesta.
    */

}
