package sample.templatemethod.complete

/**
 * Created by N1407A003 on 2015/09/07.
 */
class UserDel(args:Array[String]) extends Base {

  override def validate :Unit = {
    if (args.isEmpty) throw new RuntimeException
    println("UserDel.validate finish ===================")
  }

  override def execute :Unit = {
    println("UserDel.execute.execute finish ===================")
  }
}
