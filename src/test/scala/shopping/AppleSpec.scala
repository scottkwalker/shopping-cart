package shopping

import org.scalatest._

class AppleSpec extends FlatSpec with Matchers {
  "id" should "return expected" in {
    val apple = Apple
    apple.id should equal(0)
  }
}
