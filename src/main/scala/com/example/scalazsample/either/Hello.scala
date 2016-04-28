package com.example.scalazsample.either

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Date

import scalaz.Scalaz._
import scalaz._

object Hello {
  implicit class RichDate(val date:Date) extends AnyVal {
    def toTimestamp:Timestamp = {
      new Timestamp(date.getTime)
    }
  }
  implicit class RichString(val s:String) extends AnyVal {
    def toDate:Either[Exception, Date] = {
      try {
        val formatter = new SimpleDateFormat("yyyyMMdd")
        Right(formatter.parse(s))
      } catch {
        case e:Exception => {
         Left(e)
        }
      }
    }
  }


  def main(args: Array[String]): Unit = {
//    println("Hello, world!")
    val date = new Date
    val timestamp = date.toTimestamp
    "20151224".toDate match {
      case Right(d) => println(d)
      case Left(e) => println(e)
    }
    "2015-12-31".toDate match {
      case Right(d) => println(d)
      case Left(e) => println(e)
    }
    "aaa".toDate match {
      case Right(d) => println(d)
      case Left(e) => println(e)
    }

    val a = "aaa".right[String]
    val b = "bbb".right[String]

    val ab = for {
      aa <- a
      bb <- b
    } yield aa + bb

    println(ab.getOrElse("error"))

    val aabb = a.flatMap { aa =>
      b.map { bb =>
        aa + bb
      }
    }
  }
}
