package com.example.typesample.util

/**
  * Created by N1407A003 on 2016/04/27.
  */
case class User(name:String) {
  def hello:Unit = println(s"Hello, ${name}!")
}

object User {

  val repository:Map[String,User] = Map("Tom" -> User("Tom"), "Lucy" -> User("Lucy"))

  def findByName(name:String):Option[User] = {
    repository.get(name)
  }
}

