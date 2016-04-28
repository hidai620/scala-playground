package com.example

/**
 * Created by N1407A003 on 2016/01/26.
 */

import scala.concurrent.duration._
import scala.concurrent.{Future, Promise, Await}
import scala.concurrent.ExecutionContext.Implicits.global
import java.util.Date


object FutureSample {
  def main(args: Array[String]) {
    println(s"${new Date} start")
    val result = Future {
      (1 to 10).map { i =>
        val id = Thread.currentThread().getId
        if (id == 10) Thread.sleep(5000)
        println(s"${new Date} ${id}")
        1
      }
    }

    Await.ready(result, 20.second)
    println(s"${new Date} end")
  }
}
