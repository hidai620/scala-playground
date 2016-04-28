package com.example.forsample

/**
 * Created by N1407A003 on 2016/01/22.
 */
object ForSample {

  case class Box[A](s:A) {
    def map[B](f:A => B ):Box[B] = {
      Box(f(s))
    }
    def flatMap[B](f:A => Box[B]):Box[B] = {
      f(s)
    }
  }

  def main(args: Array[String]) {
    val intBox = Box(1)
    val stringBox = Box("hello")
    val longBox = Box(10000L)

    val result = intBox.flatMap{ i =>
      stringBox.flatMap {s =>
        longBox.map { l =>
          s"${i} : ${s} : ${l}"
        }
      }

    }
    println(result)

    val result2 = for {
      i <- intBox
      s <- stringBox
      l <- longBox
    } yield s"${i} : ${s} : ${l}"
    println (result2)

  }

}
