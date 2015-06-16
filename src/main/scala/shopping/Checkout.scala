package shopping

import shopping.products.Product

class Checkout {
  def total(products: Seq[Product]): String = {
    val costs = products.map(_.cost)
    val sum = costs.fold(0.0) ( (acc, cost) => acc + cost)
    sum.formatted("£%.2f")
  }
}
