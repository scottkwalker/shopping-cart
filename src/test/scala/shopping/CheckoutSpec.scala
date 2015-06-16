package shopping

import org.scalatest._
import shopping.products.{Apple, Orange, Product}

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

    "return £0.25 for a list containing Orange" in {
      val products = Seq[Product](Orange)
      val checkout = new Checkout
      checkout.total(products) should equal("£0.25")
    }

    "return £2.05 for a list containing Apple, Apple, Orange, Apple" in {
      val products = Seq[Product](Apple, Apple, Orange, Apple)
      val checkout = new Checkout
      checkout.total(products) should equal("£1.45")
    }

    "return £0.60 for a list containing Apple, Apple because (buy one, get one free)" in {
      val products = Seq[Product](Apple, Apple)
      val checkout = new Checkout
      checkout.total(products) should equal("£0.60")
    }

    "return £1.20 for a list containing Apple, Apple, Apple because (buy one, get one free)" in {
      val products = Seq[Product](Apple, Apple, Apple)
      val checkout = new Checkout
      checkout.total(products) should equal("£1.20")
    }

    "return £0.50 for a list containing Orange, Orange, Orange because (3 for the price of 2 )" in {
      val products = Seq[Product](Orange, Orange, Orange)
      val checkout = new Checkout
      checkout.total(products) should equal("£0.50")
    }
  }
}
