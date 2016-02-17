package com.example

/**
 */
object CakePatternSample2 {

  // model
  // impl
  class Users {
    def list = Seq("A", "B")
  }

  // component
  trait UsersComponent {
    val users:Users
  }

  // mix-in
  trait MixInUsers {
    val users = new Users
  }


  // UsersService
  //impl
  class UsersService extends MixInUsers {
    def toCSV:String = {
      users.list.mkString(",")
    }
  }

  //component
  trait UsersServiceComponent {
    val usersService:UsersService
  }

  //mix-in
  trait MixInUsersService {
    val usersService = new UsersService
  }


  // ProductService
  //impl
  class ProductService extends MixInUsers {
    def toCSV:String = {
      users.list.mkString(",")
    }
  }

  // component
  trait ProductServiceComponent {
    val productService:ProductService
  }

  // mix-in
  trait MixInProductService {
    val productService = new ProductService
  }

  //ビジネスロジック 依存性の定義
  trait UsersLogic
    extends UsersServiceComponent
    with ProductServiceComponent
    with UsersComponent

  // logic component
  trait UsersLogicComponent {
    val usersLogic:UsersLogic
  }

  // ロジック実装の提供
  trait MixInUsersLogic extends UsersLogicComponent {
    val usersLogic = new UsersLogic
                      with MixInUsers
                      with MixInUsersService
                      with MixInProductService
  }

  //実行クラス
  object UsersLogic extends MixInUsersLogic {
    def main(args: Array[String]) {
      println(usersLogic.usersService.toCSV)
    }
  }
}
