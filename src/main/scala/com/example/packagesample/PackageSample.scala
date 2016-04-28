package com.example.packagesample

/**
  * Created by N1407A003 on 2016/04/27.
  */
import com.example._ // CONST_Aをインポート
//import com.example.CONST_A // これでもいい

object PackageSample {
  def main(args: Array[String]) {
    println(CONST_A) // パッケージオブジェクト : com.exampleに含まれるCONST_A

    //CONST_Bはこのオブジェクトと同じパッケージのパッケージオブジェクトに含まれているため、
    //インポートすることなく使える。
    println(CONST_B) // パッケージオブジェクト : com.example.packagesampleに含まれるCONST_B
  }
}
