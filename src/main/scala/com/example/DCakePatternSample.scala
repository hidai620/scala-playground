package com.example

/**
  */
object DCakePatternSample {
  //モデルのインターフェース
  trait Users {
    def list:Seq[String]
  }
  //モデルの実装
  object UsersImpl extends Users {
    def list:Seq[String] = Seq("A", "B")
  }
  //モデルの実装提供
  trait UsesUsers {
    val users:Users
  }
  trait MixinUsers extends UsesUsers {
    val users:Users = UsersImpl
  }



  //サービスのインターフェース
  trait UsersService extends UsesUsers {
    def toCSV:String
  }
  //サービスの実装
  trait UsersServiceImpl extends UsersService with MixinUsers {
    def toCSV:String = {
      users.list.mkString(",")
    }
  }
  //サービスの提供
  trait UsesUsersService {
    val usersService:UsersService
  }
  trait MixinUsersService extends UsesUsersService {
    val usersService:UsersService = new UsersServiceImpl with MixinUsers
  }


  //ビジネスロジック実装クラス
  trait UsersAction {
    val usersService:UsersService

    def execute:Unit = {
      val csv = usersService.toCSV
      println(csv)
    }
  }
  //runner
  object UsersAction extends UsersAction with MixinUsersService {
    def run(args: Array[String]) {
      execute
    }
  }


  // test

  //test のサービス実装
  object TestUsersServiceImpl extends UsersService with MixinUsers {
    def toCSV:String = "test, test"
  }

  //test サービスの提供
  trait TestMixinUsersService extends UsesUsersService {
    val usersService:UsersService = TestUsersServiceImpl
  }

  //test runner
  object UsersActionSpec extends UsersAction with TestMixinUsersService {
    def run(args: Array[String]) {
      execute
    }
  }

 }
