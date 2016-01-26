package com.example

/**
 * Created by razgriz1 on 2016/01/06.
 */
object StandartLibraryEither {
  def main(args: Array[String]) {
    val result1 = Right("a")
    val result2 = Right("b")


    val r = for {
      a <- result1.right
      b <- result2.right
    } yield {
      a + b
    }

    val x = result1.right.flatMap { a =>
     result2.right.map {b =>
       a + b
     }
    }
  }

}
