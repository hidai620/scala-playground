import com.example.CakePatternSample._

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import org.specs2._

// http://etorreborre.github.io/specs2/guide/SPECS2-3.0/org.specs2.guide.UseMockito.html

/**
 * Created by razgriz1 on 2016/01/16.
 */
class CakePatternSampleSpec extends Specification with Mockito{
//  "this is my specification" >> {
//    "where example 1 must be true" >> {
//      1 must_== 1
//    }
//    "where example 2 must be true" >> {
//      2 must_== 2
//    }
//  }

  //モデルのモックの作成
  val usersMock = mock[Users]
  usersMock.list returns Seq("Tom","Alice","John")


  object TestUsersLogic extends UsersLogic with UsersServiceComponent with UsersComponent {
    val users = usersMock
    val usersService = new UsersService
  }


  "UsersService spec" >> {
    import TestUsersLogic._
    "CSV String must be correct." >> {
      val correctCsv = "Tom,Alice,John"
      usersService.toCSV must_== correctCsv
    }
  }

  "UsersLogic spec" >> {
    "execute must be success." >> {
      TestUsersLogic.execute must_== 0
    }
  }

  object FailUsersLogic extends UsersLogic with UsersServiceComponent with UsersComponent {
    val users = usersMock
    val usersService = mock[UsersService]
    usersService.toCSV throws new RuntimeException
  }
  "UsersLogic spec" >> {
    "execute must be faile." >> {
      FailUsersLogic.execute must throwA[RuntimeException]
    }
  }
}
