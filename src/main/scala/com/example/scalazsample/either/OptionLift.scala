package com.example.scalazsample.either

/**
 * Created by N1407A003 on 2016/01/22.
 */

object OptionLift {
  def main(args: Array[String]) {
    val optInt = Some(1)
    val optString = Some("1")
    val result = map2(optInt,optString)(add)
    println(result)
  }

  def add(i:Int, s:String):Long = {
    (i + s.toInt).toLong
  }

  def map2[A,B,C](optA:Option[A], optB:Option[B])(f:(A,B) => C): Option[C] = {
    optA.flatMap {a =>
      optB.map { b =>
        f(a,b)
      }
    }
  }

  def map21[A,B,C](optA:Option[A], optB:Option[B])(f:(A,B) => C): Option[C] = {
    for {
      a <- optA
      b <- optB
    } yield {
      f(a,b)
    }
  }


//  class TestParent[+A]
//  case class TestChild1[A](s:A) extends TestParent[A] {
//    def map[B](f:A => B ):TestParent[B] = {
//      TestChild1(f(s))
//    }
//    def flatMap[B](f:A => TestParent[B]):TestParent[B] = {
//      f(s)
//    }
//  }


}
