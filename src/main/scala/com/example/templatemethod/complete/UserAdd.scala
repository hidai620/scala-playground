package sample.templatemethod.complete

/**
 * Created by N1407A003 on 2015/09/07.
 */
class UserAdd(args:Array[String]) extends Base {

  override def validate :Unit = {
    if (args.isEmpty) throw new RuntimeException
    println("UserAdd.validate finish ===================")
  }

  override def execute :Unit = {
    args.foreach {println(_)}
    println("UserAdd.execute.execute finish ===================")
  }
}
