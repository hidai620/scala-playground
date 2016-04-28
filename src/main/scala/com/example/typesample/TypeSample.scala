package com.example.typesample

/**
  */
object TypeSample {

  /*
   * typeはクラスに別名を付けることが出来る
   * importせずに、クラスを使うことができる。
   */
  type User = com.example.typesample.util.User

  val tom = new User("Tom") // type Userが使用されている

  /*
   * importが必要なクラスに同じ別名をつけるだけだと、あまりありがたみが無いが、
   * パッケージオブジェクト内で使用すると、その配下のパッケージ全体で使えるようになる。
   */


  // typeでは参照したクラスのコンパニオンオブジェクトのメソッドを利用することはできない。
  // コンパニオンオブジェクトのメソッドを利用するためには、valでobjectを参照してあげるといい。
  val User = com.example.typesample.util.User
  val lucy = User.findByName("Lucy")   // val Userが使用されている


  // ただし、Javaパッケージのクラスはvalで参照できない。
  // import java.sql.Timestamp //これが必要ない
  type Timestamp = java.sql.Timestamp
  val timestamp = new Timestamp(1400000000)

  // これはできない。
  // val Timestamp = java.sql.Timestamp
  // val otherTimestamp = Timestamp.valueOf("2016-04-26 00:00:00")
}
