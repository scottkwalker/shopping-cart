package shopping

import org.scalatest._

class CheckoutSpec extends FlatSpec with Matchers {
  "total" should
    "return 0 when list is empty" in {
    val products = Seq.empty[Product]
    val checkout = new Checkout
    checkout.total(products) should equal(0)
  }
}
