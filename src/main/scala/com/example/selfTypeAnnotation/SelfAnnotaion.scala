package com.example.selfTypeAnnotation

/**
 */
trait Users {
  def list:Seq[String]
}
trait UsersImpl extends Users {
  def list:Seq[String] = Seq("John", "Alice")
}

trait TestUsersImpl extends Users {
  def list:Seq[String] = Seq("Test John", "Alice")
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

class Action {
  self:Users =>

  def index:Unit = {
    self.list
  }
}


//複数の依存関係を指定する場合
class Person {
  self: PersonOption with PersonConfig =>

  def action:Unit = {
    println(someOption)
    println(someConfig)
  }
}

trait PersonOption {
  def someOption:String = "person option"
}

trait PersonConfig {
  def someConfig:String = "person config"
}

object SelfAnnotaion {
  def main(args: Array[String]) {
    val action = new Action with UsersImpl
    println(action.list)

    val person = new Person with PersonConfig with PersonOption
    println(person.action)
  }
}
