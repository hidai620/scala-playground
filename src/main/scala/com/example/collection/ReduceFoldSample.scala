/**
 * Created by N1407A003 on 2015/08/17.
 */
object ReduceFoldSample extends App{
//  val mapResult = (1 to 10).map(x => x * 2)
  val mapResult = (1 to 10).map(x => x * 2).reduceLeft((x,y) => x + y)
  println(mapResult)

  //reduce
  val reduceResult = (1 to 10).reduceLeft { (x, y) =>
                           //途中の要素に何が入っているか確認したい場合、標準出力でデバッグするといい
                           println(s"x:$x y:$y")
                           x + y
                         }
  println(s"reduce result:$reduceResult \n")



  //fold
  val foldResult = (1 to 10).foldLeft(10) { (x, y) =>
                            println(s"x:$x y:$y")
                            x + y
                          }
  println(s"fold result: $foldResult")


  val foldResult2 = (1 to 10).foldLeft(10){_+_}
  println(s"fold result: $foldResult2")


  (1 to 10).foldLeft(10) {(x, y) => x + y}
  (1 to 10).foldLeft(10){ _ + _ }
}
