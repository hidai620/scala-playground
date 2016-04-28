package sample.templatemethod.complete

/**
 * Created by N1407A003 on 2015/09/07.
 */
object Runner {
  def main(args: Array[String]) {
    //debug arguments
    println(args.mkString(","))

    //
    args match {
      case Array("user", "-a" | "-add", _) => new UserAdd(args).run
      case Array("user", "-d" | "-delete", _) => new UserDel(args).run
    }
  }
}
