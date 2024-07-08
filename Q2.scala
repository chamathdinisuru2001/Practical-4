object PatternMatching {
	def main(args: Array[String]): Unit = {
		if (args.length != 1) {
			println("Please provide only one integer as a command line argument.")
		} else {
			try {
				val input = args(0).toInt

				val result = input match {
					case n if n <= 0 => "Negative/Zero is input"
					case n if n % 2 == 0 => "Even number is given"
					case _ => "Odd number is given"
				}

				println(result)
			} catch {
				case _: NumberFormatException => println("Please provide a valid integer.")
			}
		}
	}
}