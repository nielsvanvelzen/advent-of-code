object Day03 {
	private fun Collection<Long>.highestDigitIndex() = mapIndexed { index, battery -> battery to index }
		.maxBy { it.first }
		.second

	fun runPart1(input: String): Long {
		val banks = input.lineSequence()
			.map { bank ->
				bank.map { battery -> battery.digitToInt().toLong() }
			}

		val joltages = banks.map { bank ->
			// Pick the highest digit that is NOT the last one
			val firstIndex = bank.dropLast(1).highestDigitIndex()
			// Now skip that part nnd find the index of the next highest digit
			val secondIndex = bank.drop(firstIndex + 1).highestDigitIndex() + firstIndex + 1

			// Calculate the joltage
			val first = bank[firstIndex]
			val second = bank[secondIndex]
			val joltage = (first * 10) + second

			// Fancy debug logging!
			println("${first}${second} = $joltage")

			joltage
		}

		return joltages.sum()
	}

	fun runPart2(input: String): Long {
		val banks = input.lineSequence()
			.map { bank ->
				bank.map { battery -> battery.digitToInt().toLong() }
			}

		val joltages = banks.map { bank ->
			var lastIndex = -1
			var joltage = 0L

			repeat(12) { i ->
				val possibilities = bank.drop(lastIndex + 1).dropLast(11 - i)
				val next = possibilities.highestDigitIndex()
				lastIndex += next + 1

				joltage = (joltage * 10) + possibilities[next]
			}

			joltage
		}

		return joltages.sum()
	}
}
