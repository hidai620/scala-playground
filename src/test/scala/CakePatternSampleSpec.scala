import com.example.CakePatternSample._

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import org.specs2._

// http://etorreborre.github.io/specs2/guide/SPECS2-3.0/org.specs2.guide.UseMockito.html

/**
 * Created by razgriz1 on 2016/01/16.
 */
class CakePatternSampleSpec extends Specification with Mockito{

  //モデルのモックの作成
  val usersMock = mock[Users]


  object TestUsersLogic
    extends ProductServiceComponent
      with UsersServiceComponent
      with UsersComponent {

    usersMock.list returns Seq("Tom","Alice","John")

    val users = usersMock
    val usersService = new UsersService
    val productService = new ProductService
  }


  "UsersService spec" >> {
    import TestUsersLogic._
    "CSV String must be correct." >> {
      val correctCsv = "Tom,Alice,John"
      usersService.toCSV must_== correctCsv
    }
  }


  object FailUsersLogic
    extends UsersServiceComponent
      with ProductServiceComponent
      with UsersComponent {

    val usersServiceMock = mock[UsersService]
    usersServiceMock.toCSV throws new RuntimeException

    val users = usersMock
    val usersService = usersServiceMock
    val productService = new ProductService
  }

  "UsersLogic spec" >> {
    "execute must be faile." >> {
      FailUsersLogic.usersService.toCSV must throwA[RuntimeException]
    }
  }
}
