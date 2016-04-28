package com.example.forsample

/**
 * Created by N1407A003 on 2016/01/22.
 */
object ForSampleOption {

  def main(args: Array[String]) {
    val intOption = Array(1,2)
    val stringOption = Some("hello")
    val longOption = Some(10000L)

    val result =
      intOption.flatMap{ i =>
        stringOption.flatMap {s =>
          val r = longOption.map { l =>
            s"${i} : ${s} : ${l}"
          }
          r
        }

    }
    println(result)
    result.foreach {println(_)}







    val result2 = for {
      i <- intOption
      s <- stringOption
      l <- longOption
    } yield s"${i} : ${s} : ${l}"
    println (result2)
    result2.foreach {println(_)}
  }

}
