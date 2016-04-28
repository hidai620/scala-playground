package com.example.scalazsample.either

/**
 * Created by razgriz1 on 2016/01/06.
 */
object StandardLibraryEither {
  def main(args: Array[String]) {
    val result1 = Right("a")
    //val result2 = Right("b")
    val result2 = Left(new RuntimeException("error"))


    val r = for {
      a <- result1.right
      b <- result2.right
    } yield {
      a + b
    }

    println(r)
    r.right.map { s =>
      println(s)
    }


    val x = result1.right.flatMap { a =>
     result2.right.map {b =>
       a + b
     }
    }
  }

}
