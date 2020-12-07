object Day7 {
	data class Condition(val amount: Int, val type: String)

	fun run(input: String) {
		val rules = input.lines().map { line ->
			val (currentType, rh) = line.split(" bags contain ")
			val conditions = rh.split(",").mapNotNull { condition ->
				if (condition.contains("no other bags")) null
				else condition.let {
					val (amount, type) = condition.trim().split(" ", limit = 2)
					// it works
					Condition(amount.toInt(), type.removeSuffix(".").removeSuffix("bags").removeSuffix("bag").trim())
				}
			}

			currentType to conditions
		}.toMap()

		val possibleBags = mutableSetOf<String>()
		fun recursiveCheck(needle: String) {
			rules.filter { rule ->
				rule.key !in possibleBags
			}.filter { rule ->
				rule.value.any { condition -> condition.type == needle }
			}.forEach { rule ->
				possibleBags.add(rule.key)
				recursiveCheck(rule.key)
			}
		}

		recursiveCheck("shiny gold")
		println("Found ${possibleBags.size} possible bags to contain shiny gold")

		fun recursiveContentCheck(needle: String): Int =
			rules[needle]!!.map { recursiveContentCheck(it.type) * it.amount }.sum() + 1
		println("A shiny gold bag will nest ${recursiveContentCheck("shiny gold") - 1} other bags")
	}
}
