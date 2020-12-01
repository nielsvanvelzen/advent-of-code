object Day1 {
	fun run(input: String) {
		val needle = 2020
		val expenses = input.split("\n").map { it.toInt() }.sorted()
		expenses.forEach { a ->
			expenses.asReversed().forEach { b ->
				if (a + b == needle) {
					println("$a + $b = $needle | $a * $b = ${a * b}")
				}
			}
		}
	}
}
