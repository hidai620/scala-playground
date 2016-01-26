package com.example

/**
 */
object CakePatternSample {

  object Result {
    val success = 0
    val fatal = 1
  }

  //model
  class Users {
    def list = Seq("A", "B")
  }
  trait UsersComponent {
    val users:Users
  }

  //service
  trait UsersServiceComponent {
    this:UsersComponent =>
    val usersService:UsersService

    class UsersService {
      def toCSV:String = {
        users.list.mkString(",")
      }
    }
  }

  trait ProductServiceComponent {
    this:UsersComponent =>
    val productService:ProductService

    class ProductService {
      def toCSV:String = {
        users.list.mkString(",")
      }
    }
  }


  //ビジネスロジック
  trait UsersLogic extends UsersServiceComponent with ProductServiceComponent with UsersComponent {
    def execute:Int = {
      println(usersService.toCSV)
      Result.success
    }
  }


  //runner
  object UsersLogic extends UsersLogic {
    val users = new Users
    val usersService = new UsersService
    val productService = new ProductService

    def run(args:Array[String]):Unit = {
      execute
    }
  }

  def main(args: Array[String]) {
    println(UsersLogic.usersService.toCSV)
  }
}
