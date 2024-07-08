import scala.io.StdIn.readLine

object InventoryManagementSystem{
    var itemNames: Array[String]=Array("Apple","Samasung","Huawei","Sony","Oneplus","Xiaomi")
    var itemQuantities: Array[Int]=Array(20,50,5,16,20,45)

    //display inventory
    def displayInventory():Unit={
        println("-----------Current inventory-----------")
        for(i<-itemNames.indices){
            println(s"${itemNames(i)}:${itemQuantities(i)}")
        }
    }

    //restock item
    def restockItem(itemName: String, $quantity: Int):Unit={
        val index = itemNames.indexOf(itemName)
        if(index != -1){
            itemQuantities(index) += $quantity
            println(s"Restocked $itemName. New quantity: ${itemQuantities(index)}")
        }else{
            println(s"Item '$itemName' dose not exist in the inventory...")
        }
    }

    //sell item
    def sellItem(itemName: String, quantity: Int): Unit = {
        val index = itemNames.indexOf(itemName)
        if (index != -1) {
            if (itemQuantities(index) >= quantity) {
                itemQuantities(index) -= quantity
                println(s"Sold $quantity of $itemName. Remaining quantity: ${itemQuantities(index)}")
        } else {
                println(s"Not enough $itemName in the inventory to sell $quantity. Available quantity: ${itemQuantities(index)}")
        }
        } else {
            println(s"Item '$itemName' does not exist in the inventory.")
        }
    }

    def main(args: Array[String]): Unit = {
		var continue = true

		while (continue) {
			println("\n-----------Select an option-----------")
			println("1. Display Inventory")
			println("2. Restock Item")
			println("3. Sell Item")
			println("4. Exit")

			val choice = readLine().toInt

			choice match {
				case 1 =>
					displayInventory()
				case 2 =>
					print("Enter item name to restock: ")
					val itemName = readLine()
					print("Enter quantity to add: ")
					val quantity = readLine().toInt
					restockItem(itemName, quantity)
				case 3 =>
					print("Enter item name to sell: ")
					val itemName = readLine()
					print("Enter quantity to sell: ")
					val quantity = readLine().toInt
					sellItem(itemName, quantity)
				case 4 =>
					println("Exiting...")
					continue = false
				case _ =>
					println("Invalid option. Please try again.")
			}
		}
	}
}