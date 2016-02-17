package com.example

import java.sql.Timestamp

/**
  * Created by razgriz1 on 2016/01/30.
  */
class TypeSample {
  type Timestamp = java.sql.Timestamp

  def main(args: Array[String]) {
    Timestamp.valueOf("2015-12-12 00:00:00")
  }
}
