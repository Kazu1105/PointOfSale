package store.model.checkout
import store.model.items.Item
import store.view.SelfCheckoutGUI._
import scala.:+

class SelfCheckout {
  var pressed:String=""
  var storage:Map[String,Item]=Map()
  //storage is the barcode -> item
  var cart:List[Item]=List()
  var errorobj:Item= new Item("error", 0.0)

  def addItemToStore(barcode: String, item: Item): Unit = {
    storage += (barcode->item)
    // This method adds an item to your store's checkout system. It does not add an item to the customer's cart
    // TODO
  }
  def numberPressed(number: Int): Unit = {
    pressed=pressed+number
    // TODO
  }

  def clearPressed(): Unit = {
    pressed=""
    // TODO
  }

  def enterPressed(): Unit = {
    //appends the values in the storage into item while returning error if the barcode does not match an item
    //storage is the item
    cart= cart:+storage.getOrElse(pressed,errorobj)
    pressed=""
    // TODO
  }

  def checkoutPressed(): Unit = {
    // TODO
  }

  def cashPressed(): Unit = {
    // TODO
  }

  def creditPressed(): Unit = {
    // TODO
  }

  def loyaltyCardPressed(): Unit = {
    // TODO
  }

  def displayString(): String = {
    pressed
    // TODO
  }

  def itemsInCart(): List[Item] = {
    cart
  }
  def subtotal(): Double = {
    0.0
  }

  def tax(): Double = {
    0.0
  }

  def total(): Double = {
    0.0
    /*
    total1=subtotal1+tax1
    total1*/
  }

  def prepareStore(): Unit = {
    // Similar to openMap in the Pale Blue Dot assignment, this method is not required and is
    // meant to help you run manual tests.
    //
    // This method is called by the GUI during setup. Use this method to prepare your
    // items and call addItemToStore to add their barcodes. Also add any sales/tax/etc to your
    // items.
    //
    // This method will not be called during testing and you should not call it in your tests.
    // Each test must setup its own items to ensure compatibility in AutoLab. However, you can
    // write a similar method in your Test Suite classes.

    // Example usage:
    //val testItem: Item = new Item("test item", 100.0)
    //this.addItemToStore("472", testItem)
  }

}
