package com.ejemplos.actores.basico3

import akka.actor.{ActorSystem, Props}
import com.ejemplos.actores.basico3.ExpedirSolicitudes.Expedir

/**
  * Created by ALEJANDRO on 09/12/2016.
  */
object MainBasico3 extends App{

  /**
    * Se crea el sistema de actores en la JVM.
    */
  val system = ActorSystem("mySystem")

  /**
    * Se crea en el sistema de actores una instancia del MyActor1 y se le llama myActor.
    * Dicha instancia puede ser llamada por su nombre en cualquier momento.
    */
  val myActorExpedir = system.actorOf(Props[ExpedirSolicitudes], "myActor")

  // se le manda un mensaje "hola mundo" al actor MyActor1.
  myActorExpedir ! Expedir("expida")


  Thread.sleep(20000)

}
