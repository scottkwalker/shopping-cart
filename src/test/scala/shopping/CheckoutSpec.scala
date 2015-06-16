package shopping

import org.scalatest._
import shopping.products.{Apple, Product}

class CheckoutSpec extends WordSpec with Matchers {
  "total" should {
    "return £0.00 when list is empty" in {
      val products = Seq.empty[Product]
      val checkout = new Checkout
      checkout.total(products) should equal("£0.00")
    }

    "return £0.60 for a list containing Apple" in {
      val products = Seq[Product](Apple)
      val checkout = new Checkout
      checkout.total(products) should equal("£0.60")
    }

//    "return £2.05 for a list containing Apple, Apple, Orange, Apple" in {
//      val products = Seq.empty[Product]
//      val checkout = new Checkout
//      checkout.total(products) should equal("£2.05")
//    }
  }
}
