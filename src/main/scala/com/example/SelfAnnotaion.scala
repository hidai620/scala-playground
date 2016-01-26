package com.example

/**
 */
object SelfAnnotaion {
  trait Users {
    def list:Seq[String]
  }

  trait UsersImpl extends Users {
    def list:Seq[String] = Seq("Maki Horikita", "Kiko Mizuhara")
  }

  trait TestUsersImpl extends Users {
    def list:Seq[String] = Seq("Test Maki Horikita", "Test Kiko Mizuhara")
  }

  trait UsersService {
    def toCSV:String
  }

  trait UsersServiceImpl extends UsersService {
    this:Users =>
    def toCSV:String = {
      list.mkString(",")
    }
  }
  trait ProductService {
    val users:Users
    def toCSV:String
  }

  trait ProductServiceImpl extends ProductService {
    this:Users =>
    def toUsersCSV:String = {
      list.mkString(",")
    }
  }

  class UsersAction {
    this:UsersService =>

    def index:Unit = {
      this.toCSV
    }
  }


  def main(args: Array[String]) {
    val usersAction = new UsersAction with UsersServiceImpl  with UsersImpl
    println(usersAction.index)

    val testUsersAction = new UsersAction with UsersServiceImpl with TestUsersImpl
    println(testUsersAction.toCSV)
  }
}
