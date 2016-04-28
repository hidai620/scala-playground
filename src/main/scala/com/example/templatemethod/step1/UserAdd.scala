package sample.templatemethod.step1

/**
 * Created by N1407A003 on 2015/09/07.
 */
object Runner {

  def main(args: Array[String]) {
    //debug arguments
    println(args.mkString(" "))

    //
    UserAdd(args).run
  }
}

case class UserAdd(args: Array[String]) {
  def run:Unit = {
    try {
      validate

      execute
    } catch {
      case e:Exception => {
        e.printStackTrace
      }
    }
  }

  def validate :Unit = {
    if (args.isEmpty) throw new RuntimeException
    println("Runner.validate finish ===================")
  }

  def execute :Unit = {
    args.foreach {println(_)}
    println("Runner.execute.execute finish ===================")
  }
}
