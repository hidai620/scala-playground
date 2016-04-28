package com.example.privatethis

/**
  * Created by N1407A003 on 2016/04/27.
  */
object PrivateThisSample {

}

class User {
  private val SOME_CONSTANTS = "AAA"
  def showName(user:User):Unit = {
    println(user.SOME_CONSTANTS) // private なのに、同じクラスではインスタンスのprivateプロパティを参照できる
  }
}

class PrivateUser {
  private[this] val SOME_CONSTANTS = "AAA"
  def showName(user:PrivateUser):Unit = {
    // compile error private[this]キーワードで宣言したプロパティは、同じクラスであっても、
    // インスタンスのプロパティを参照できない。
    //println(user.SOME_CONSTANTS)
  }
}
