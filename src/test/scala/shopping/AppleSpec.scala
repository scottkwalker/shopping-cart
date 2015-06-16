package shopping

import org.scalatest._

class AppleSpec extends FlatSpec with Matchers {
  "id" should "return expected" in {
    val apple = Apple
    apple.id should equal(0)
  }

  "cost" should "return 60p" in {
    val apple = Apple
    apple.cost should equal(0.60)
  }
}
