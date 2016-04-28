package sample

/**
  * Created by N1407A003 on 2016/02/01.
  */
object FunctionDefine {


  def retry(count:Int, f: => Unit):Unit = {
    f
  }

  def retry2(count:Int)(f: => Unit):Unit = {
    f
  }

  def logic = {
    println("aaaaa")
  }


  def main(args: Array[String]) {
    retry(10, {
        println("aaaaa")
      }
    )

    retry(10, logic)

    retry2(10) {
      println("aaaaa")
    }
  }

}
