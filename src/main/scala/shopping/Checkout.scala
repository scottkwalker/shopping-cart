package shopping

import shopping.products.{Apple, Product}

class Checkout {
  def total(products: Seq[Product]): String = {
    val costs = products.map(_.cost)
    val sum = costs.fold(0.0) ( (acc, cost) => acc + cost)
    val sumAfterSpecialOffers = sum - specialOffers(sum, products)
    sumAfterSpecialOffers.formatted("£%.2f")
  }

  def specialOffers(sum: Double, products: Seq[Product]): Double =
    apples(products)

  def apples(products: Seq[Product]): Double = {
    val numberOfApples = products.count{ product => product.id == Apple.id }
    val applesNotForFree: Int = scala.math.ceil(numberOfApples / 2).toInt
    applesNotForFree * Apple.cost
  }
}
