package com.ejemplos.actores.basico1

import akka.actor.Actor
import akka.actor.Actor.Receive

/**
  * Created by ALEJANDRO on 03/10/2016.
  *
  * Clase Actor basic que extiende de la clase Actor de akka.
  *
  */
class MyActor1 extends Actor {

  /**
    * Implementacion del metodo receive, dicho metodo se hereda del trait Actor
    * y define  el mensaje que espera el actor.
    *
    * Para definir los ensajes que espera el actor se utiliza un patther machine
    * de Scala.
    *
    */
  override def receive: Receive = {

    // El actor espera una cadena "hola mundo".
    case "hola mundo" => println("hola mundo !!")
    // En caso de cualquier otro mensaje.
    case _ => println("hola cualquier otro mensaje !!")

  }

}
