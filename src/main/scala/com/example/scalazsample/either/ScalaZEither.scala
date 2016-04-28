package com.example.scalazsample.either

import scalaz.Scalaz._
import scalaz._

/**
 */
object ScalaZEither {
  def main(args: Array[String]) {
    case class NGResult(message:String, success:Boolean)
    val riakCSClientE = "client".right[RuntimeException]
//    val riakCSuserE = "create user".right[RuntimeException]
      val riakCSuserE = new Exception("create user failed").left[String]
//    val riakCSuserE = NGResult("create user failed", false).left[NGResult]
//    val riakCSuserE = NGResult("create user failed", false).left[String]

    val option = Some("option").\/>("either")

    val result = for {
     riakCSClient <- riakCSClientE.leftMap(s => s)
     riakCSUser <- riakCSuserE.leftMap(e => e)
    } yield {
      riakCSClient + riakCSUser
    }

    result match {
      case -\/(s) => println(s"left: ${s}")
      case \/-(s) => {
        println(s"right: ${s}")
      }
    }

//    List(1.right[Throwable], 2.right[Throwable]).sequence[({ type X[A] = Either[Throwable, A] })#X, Int]
//    List(1.right[Throwable], 2.right[Throwable]).sequence[Either[Throwable, Int], Int]
//    println(result)
//    result.map(r => println(r))
//    val result = (1 to 10).flatMap {
//      case a if a%2 == 0 => Some(a)
//      case a:Int => Some(a*3)
//    }
//    println(result)
//
//    val pow:Function2[Int,Int,Int] = {
//      case (x:Int,y:Int) if x == 1 => 2*2
//      case (x:Int,y:Int) => x*2
//    }
//
//    val pow2 = (x:Int, y:Int) => {
//      (x,y) match {
//        case (x: Int, y: Int) if x == 1 => 2 * 2
//        case (x: Int, y: Int) => x * 2
//      }
//    }
//    println(pow(2,2))
//    println(pow(1,1))
  }
  def sumTest:Unit = {
    val e1 = 1.right[String]
    val e2 = 0.right[String]
    val a = for {
      a <- e1
      b <- e2
      c = a + b
      if c > 0
    } yield c

    a.map(println(_))
  }
}
