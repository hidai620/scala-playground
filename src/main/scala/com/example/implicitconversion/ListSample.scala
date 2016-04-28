package sample.implicitconversion

/**
 * Created by N1407A003 on 2015/09/01.
 */
object ListSample extends App{

  val scalaSet = Set("A","B", "C")
  scalaSet.foreach(println(_))

  import java.util._
  import scala.collection.JavaConversions._
  val javaList = new ArrayList[String]()
  javaList.add("A")
  javaList.add("B")
  javaList.add("C")
  javaList.foreach(println(_))

  import com.example.implicitconversion.util.Util.RichArrayList
  val intList = javaList.toIntList

  val extendArrayList = new RichArrayList(javaList)
  val intlist = extendArrayList.toIntList
}

