package com.example

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import java.util.Date
import scala.concurrent.duration.Duration

/**
 */
//futureのmapは別のfutureを返す
object FutureSample {
  def main(args: Array[String]) {
    val a = Future {
      println(2)
      println(s"in future: ${new Date}")
      //Thread.sleep(1000)
      println(4)
      Right(new Date())
    }
    println(1)

    val b = a.map {
      case Right(d) => println(s"in callback:${d}"); println(5)
      case _ => println(s"in failer callback:")
    }
    println(3)
    println(b)
    Await.ready(b, Duration.Inf)
    println(6)
  }
}
