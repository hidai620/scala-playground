package com.example

import scalaz._
import Scalaz._

/**
 */
object OptionStudy {

  def main(args: Array[String]) {
    val taroAddress = getAddressOption("taro")
    val tomAddress = getAddressOption("tom")
    val aliceAddress = getAddressOption("alice")

//    taroAddress.map { a =>
//      tomAddress.map { b =>
//        println("両方あった")
//      }
//    }


    for {
      a <- taroAddress orElse Some("aはなかった")
      b <- aliceAddress orElse Some("bはなかった")
    } {
      println(a)
      println(b)
    }
  }

  val addresses = Map("taro" -> "America", "tom" -> "Canada")

  def getAddressOption(name:String):Option[String] = {
    addresses.get(name)
  }

}
