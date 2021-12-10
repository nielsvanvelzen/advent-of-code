object Day08 {
	fun runPart1(input: String): Int {
		val uniqueLengths = arrayOf(
			2, // 1
			4, // 4
			3, // 7
			7, // 8
		)

		return input.lines().sumOf { entry ->
			entry.split(" |").last().split(' ').count { outputValue ->
				outputValue.length in uniqueLengths
			}
		}
	}
}
