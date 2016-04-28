package com.example.cakepattern

/**
 */
object SelfAnnotation {
  trait Users {
    def list:Seq[String]
  }

  trait UsersImpl extends Users {
    def list:Seq[String] = Seq("John", "Alice")
  }

  trait TestUsersImpl extends Users {
    def list:Seq[String] = Seq("Test John", "Test Alice")
  }

  trait UsersService {
    def toCSV:String
  }

  trait UsersServiceImpl extends UsersService {
    self:Users =>
    def toCSV:String = {
      list.mkString(",")
    }
  }
  trait ProductService {
    def toUsersCSV:String
  }

  trait ProductServiceImpl extends ProductService {
    self:Users =>
    def toUsersCSV:String = {
      list.mkString(",")
    }
  }

  class UsersAction {
    self:UsersService with ProductService =>

    def execute:Unit = {
      println(this.toCSV)
    }
  }


  def main(args: Array[String]) {
    val usersAction = new UsersAction with UsersServiceImpl with ProductServiceImpl with UsersImpl
    usersAction.execute
    usersAction.toCSV

    val testUsersAction = new UsersAction with UsersServiceImpl with ProductServiceImpl with TestUsersImpl
    testUsersAction.execute
  }
}
