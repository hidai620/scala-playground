package sample.templatemethod.complete

/**
 * Created by N1407A003 on 2015/09/07.
 */
trait Base {
  def run:Unit = {
    try {
      this.getClass.getFields.foreach { f =>
        println(s"${f.getName} : ${f.get(this)}")
      }
      validate
      execute
      after
    } catch {
      case e:Exception => {
        e.printStackTrace
      }
    }
  }

  // 個別に定義させたい処理は実装をもたない
  def execute:Unit

  // バリデーション
  def validate:Unit

  // after
  def after:Unit = {
    println("after ======================")
  }
}

