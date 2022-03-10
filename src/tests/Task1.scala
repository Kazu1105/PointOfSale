package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.Item

class Task1 extends FunSuite {

  test("number") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    assert(testSelfCheckout.displayString() == "")
    testSelfCheckout.numberPressed(4)
    assert(testSelfCheckout.displayString() == "4")
    testSelfCheckout.numberPressed(7)
    assert(testSelfCheckout.displayString() == "47")
    testSelfCheckout.numberPressed(2)
    assert(testSelfCheckout.displayString() == "472")
  }
  test("clear"){
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    assert(testSelfCheckout.displayString() == "")
    testSelfCheckout.numberPressed(4)
    assert(testSelfCheckout.displayString() == "4")
    testSelfCheckout.numberPressed(7)
    assert(testSelfCheckout.displayString() == "47")
    testSelfCheckout.numberPressed(2)
    assert(testSelfCheckout.displayString() == "472")
    testSelfCheckout.clearPressed()
    assert(testSelfCheckout.displayString() == "")
  }

  test("enter") {
    val checkout: SelfCheckout = new SelfCheckout()
    val testItem: Item = new Item("test item", 100.0)
    checkout.addItemToStore("472", testItem)
    checkout.numberPressed(4)
    checkout.numberPressed(7)
    checkout.numberPressed(2)
    checkout.enterPressed()
    val cart: List[Item] = checkout.itemsInCart()
    assert(cart.size == 1)
    assert(testItem.description() == "test item")
    assert(Math.abs(cart.head.price() - 100.0) < 0.001)
    assert(checkout.displayString() == "")
  }
  test("no value in barcode") {
    val checkout: SelfCheckout = new SelfCheckout()
    checkout.numberPressed(4)
    checkout.numberPressed(7)
    checkout.numberPressed(2)
    checkout.enterPressed()
    val cart: List[Item] = checkout.itemsInCart()
    assert(cart.head.description() == "error")
    assert(Math.abs(cart.head.price() - 0.0) < 0.001)
    assert(checkout.displayString() == "")
  }
  test("2 same item"){
    val checkout: SelfCheckout= new SelfCheckout
    val item:Item= new Item("pen", 5.0)
    checkout.addItemToStore("123",item)
    checkout.numberPressed(1)
    checkout.numberPressed(2)
    checkout.numberPressed(3)
    checkout.enterPressed()
    checkout.numberPressed(1)
    checkout.numberPressed(2)
    checkout.numberPressed(3)
    checkout.enterPressed()
    val cart:List[Item]=checkout.itemsInCart()
    assert(cart.size==2)
    assert(cart.head.description()=="pen")
    assert(Math.abs(cart.head.price() - 5.0) < 0.001)
    assert(cart(1).description()=="pen")
    assert(Math.abs(cart(1).price() - 5.0) < 0.001)
  }
  test("2 items"){

    val checkout: SelfCheckout= new SelfCheckout
    val item:Item= new Item("pen", 5.0)
    val item1:Item= new Item("pencil", 2.5)
    checkout.addItemToStore("123",item)
    checkout.addItemToStore("122",item1)
    checkout.numberPressed(1)
    checkout.numberPressed(2)
    checkout.numberPressed(3)
    checkout.enterPressed()
    checkout.numberPressed(1)
    checkout.numberPressed(2)
    checkout.numberPressed(2)
    checkout.enterPressed()
    val cart:List[Item]=checkout.itemsInCart()
    assert(cart.size==2)
    assert(cart.head.description()=="pen")
    assert(Math.abs(cart.head.price() - 5.0) < 0.001)
    assert(cart(1).description()=="pencil")
    assert(Math.abs(cart(1).price() - 2.5) < 0.001)
  }
  test("always same item"){
      val checkout: SelfCheckout= new SelfCheckout
      val item:Item= new Item("pen", 5.0)
      checkout.addItemToStore("123",item)
      checkout.numberPressed(1)
      checkout.numberPressed(2)
      checkout.numberPressed(3)
      checkout.enterPressed()
      checkout.numberPressed(1)
      checkout.numberPressed(2)
      checkout.numberPressed(3)
      checkout.enterPressed()
      checkout.numberPressed(1)
      checkout.numberPressed(2)
      checkout.numberPressed(3)
      checkout.enterPressed()
      val cart:List[Item]=checkout.itemsInCart()
      assert(cart.size==3)
      assert(cart.head.description()=="pen")
      assert(Math.abs(cart.head.price() - 5.0) < 0.001)
      assert(cart(1).description()=="pen")
      assert(Math.abs(cart(1).price() - 5.0) < 0.001)
      assert(cart.head.description()=="pen")
      assert(Math.abs(cart.head.price() - 5.0) < 0.001)

  }
  test("start with 0"){
    val checkout: SelfCheckout = new SelfCheckout()
    val testItem: Item = new Item("test item", 900.0)
    checkout.addItemToStore("072", testItem)
    checkout.numberPressed(0)
    checkout.numberPressed(7)
    checkout.numberPressed(2)
    checkout.enterPressed()
    val cart: List[Item] = checkout.itemsInCart()
    assert(cart.size == 1)
    assert(testItem.description() == "test item")
    assert(Math.abs(cart.head.price() - 900.0) < 0.001)
    assert(checkout.displayString() == "")
  }
  test("change values"){

    val checkout: SelfCheckout = new SelfCheckout()
    val testItem: Item = new Item("test item", 90.0)
    checkout.addItemToStore("072", testItem)
    checkout.numberPressed(0)
    checkout.numberPressed(7)
    checkout.numberPressed(2)
    checkout.enterPressed()
    val cart: List[Item] = checkout.itemsInCart()
    assert(cart.size == 1)
    assert(testItem.description() == "test item")
    assert(Math.abs(cart.head.price() - 90.0) < 0.001)
    assert(checkout.displayString() == "")
    testItem.setBasePrice(50.0)
    assert(Math.abs(cart.head.price() - 50.0) < 0.001)

  }

}
