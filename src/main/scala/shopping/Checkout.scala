package shopping

import shopping.products.{Orange, Apple, Product}

class Checkout {
  def total(products: Seq[Product]): String = {
    val costs = products.map(_.cost)
    val sum = costs.fold(0.0) ( (acc, cost) => acc + cost)
    val sumAfterSpecialOffers = sum - specialOffers(sum, products)
    sumAfterSpecialOffers.formatted("£%.2f")
  }

  private def specialOffers(sum: Double, products: Seq[Product]): Double =
    apples(products) + oranges(products)

  private def apples(products: Seq[Product]): Double = {
    val numberOfApples = products.count{ product => product.id == Apple.id }
    val applesForFree: Int = scala.math.floor(numberOfApples / 2).toInt
    applesForFree * Apple.cost
  }

  private def oranges(products: Seq[Product]): Double = {
    val numberOfOranges = products.count{ product => product.id == Orange.id }
    val orangesForFree: Int = scala.math.ceil(numberOfOranges / 3).toInt
    orangesForFree * Orange.cost
  }
}
