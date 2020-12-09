@OptIn(ExperimentalStdlibApi::class)
object Day9 {
	fun run(input: String, preamble: Int = 25) {
		val numbers = input.lines().map { it.toLong() }
		var firstInvalid = -1L

		numbers.forEachIndexed { index, number ->
			// Skip initial numbers
			if (index < preamble) return@forEachIndexed

			val head = numbers.subList(index - preamble, index)
			val sums = buildList {
				head.forEach { a ->
					head.forEach { b ->
						val sum = a + b
						if (a != b && !contains(sum)) add(sum)
					}
				}
			}

			if (number !in sums && firstInvalid == -1L)
				firstInvalid = number
		}

		println("firstInvalid: $firstInvalid")

		fun visit(index: Int, accumulator: Long, needle: Long): List<Long> {
			val number = numbers[index]
			val sum = number + accumulator

			return when {
				sum > needle -> emptyList()
				sum == needle -> listOf(number)
				else -> visit(index + 1, sum, needle).let {
					if (it.isNotEmpty()) it + number
					else it
				}
			}
		}

		var weakness = -1L
		numbers.forEachIndexed { index, _ ->
			val res = visit(index, 0L, firstInvalid)

			if (res.isNotEmpty() && weakness == -1L) {
				println(res)
				weakness = res.minOrNull()!! + res.maxOrNull()!!
			}
		}

		println("weakness: $weakness")
	}
}
