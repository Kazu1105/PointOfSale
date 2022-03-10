package store.model.items

class Item (val theDescription: String, var BasePrice: Double){

  // TODO: Complete this class according to the features listed in the HW document

  def description(): String = {
    theDescription
  }
  def setBasePrice(newprice: Double): Unit={

    BasePrice = newprice
  }

  def price(): Double = {
    var price:Double=0.0
    price=price+BasePrice
    price
  }


}
