object Day01 {
	fun runPart1(input: String): Int {
		return input.lineSequence()
			// Drop empty lines
			.filterNot { value -> value.isEmpty() }
			// Get first and last digits and convert to int
			.map { value ->
				val digits = value.filter { char -> char.isDigit() }
				"${digits.first()}${digits.last()}".toInt()
			}
			// Sum
			.sum()
	}

	fun runPart2(input: String): Int {
		val digits = mapOf(
			"1" to 1,
			"2" to 2,
			"3" to 3,
			"4" to 4,
			"5" to 5,
			"6" to 6,
			"7" to 7,
			"8" to 8,
			"9" to 9,

			"one" to 1,
			"two" to 2,
			"three" to 3,
			"four" to 4,
			"five" to 5,
			"six" to 6,
			"seven" to 7,
			"eight" to 8,
			"nine" to 9,
		)

		return input.lineSequence()
			// Drop empty lines
			.filterNot { value -> value.isEmpty() }
			// Replace spelled out digits
			.map { value ->
				// <position, digit>
				var first: Pair<Int, Int?> = 0 to null
				var last: Pair<Int, Int?> = 0 to null

				for ((digitString, digitInt) in digits) {
					val firstIndex = value.indexOf(digitString)
					val lastIndex = value.lastIndexOf(digitString)

					if (firstIndex != -1 && (firstIndex < first.first || first.second == null)) first = firstIndex to digitInt
					if (lastIndex != -1 && (lastIndex > last.first || last.second == null)) last = lastIndex to digitInt
				}

				if (first.second == null || last.second == null) error("Invalid value")

				"${first.second}${last.second}".toInt()
			}
			// Sum
			.sum()
	}
}
