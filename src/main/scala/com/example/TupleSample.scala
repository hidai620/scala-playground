package com.example

/**
  * Created by N1407A003 on 2016/02/01.
  */
object TupleSample {

  def getTuple:(String,String) = {
    ("a", "b")
  }

  def main(args: Array[String]) {
    val tuple = getTuple

    println(tuple._1)
    println(tuple._2)

    val (a , b) = getTuple
    println(a)
    println(b)

  }

}
