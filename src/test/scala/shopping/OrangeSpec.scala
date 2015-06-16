package shopping

import org.scalatest._

class OrangeSpec extends FlatSpec with Matchers {
   "id" should "return expected" in {
     val orange = Orange
     orange.id should equal(1)
   }

   "cost" should "return 25p" in {
     val orange = Orange
     orange.cost should equal(0.25)
   }
 }
