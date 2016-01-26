package com.example

import scalaz._
import Scalaz._

/**
 */
object ScalaZEither {
  def main(args: Array[String]) {
    val e1 = 1.right[String]
    val e2 = 0.right[String]
    val a = for {
      a <- e1
      b <- e2
      c = a + b
      if c > 0
    } yield c

    a.map(println(_))


    val result = (1 to 10).flatMap {
      case a if a%2 == 0 => Some(a)
      case a:Int => Some(a*3)
    }
    println(result)

    val pow:Function2[Int,Int,Int] = {
      case (x:Int,y:Int) if x == 1 => 2*2
      case (x:Int,y:Int) => x*2
    }

    val pow2 = (x:Int, y:Int) => {
      (x,y) match {
        case (x: Int, y: Int) if x == 1 => 2 * 2
        case (x: Int, y: Int) => x * 2
      }
    }
    println(pow(2,2))
    println(pow(1,1))
  }
}
