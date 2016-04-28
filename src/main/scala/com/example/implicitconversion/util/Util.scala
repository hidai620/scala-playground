package com.example.implicitconversion.util

/**
 * Created by N1407A003 on 2015/09/01.
 */
object Util {
  import java.util.ArrayList

  implicit class RichArrayList(list:ArrayList[String]) {
    def toIntList:List[Int] = {
      import scala.collection.JavaConversions._
      list.map{s => s.toInt}.toList
    }
  }

}
