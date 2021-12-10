import kotlin.math.pow

object Day08 {
	fun runPart1(input: String): Int {
		val uniqueLengths = arrayOf(
			2, // 1
			4, // 4
			3, // 7
			7, // 8
		)

		return input.lines().sumOf { entry ->
			entry.split(" | ").last().split(' ').count { outputValue ->
				outputValue.length in uniqueLengths
			}
		}
	}

	fun runPart2(input: String): Int {
		return input.lines().sumOf { entry ->
			val (signalPatterns, outputValues) = entry.split(" | ").map { group ->
				group.split(' ').map { pattern ->
					pattern.toList().sorted().joinToString("")
				}
			}

			val values = mutableMapOf<String, Int>()

			// First iteration: find unique values
			for (signalPattern in signalPatterns) {
				when (signalPattern.length) {
					2 -> values[signalPattern] = 1
					3 -> values[signalPattern] = 7
					4 -> values[signalPattern] = 4
					5 -> values[signalPattern] = -5 // 2, 3 or 5
					6 -> values[signalPattern] = -6 // 0, 6 or 9
					7 -> values[signalPattern] = 8
				}
			}

			// Second iteration: find 0, 6 and 9
			// known: 1, 4, 7, 8
			// unknown: 0, 2, 3, 5, 6, 9
			val one = values.entries.first { it.value == 1 }.key
			val four = values.entries.first { it.value == 4 }.key

			for (signalPattern in signalPatterns) {
				if (values[signalPattern] != -6) continue

				if (signalPattern.count { it in one } == 1) values[signalPattern] = 6
				else if (signalPattern.count { it in four } == 3) values[signalPattern] = 0
				else values[signalPattern] = 9
			}

			// Third iteration: find 2, 3 or 5
			// known: 0, 1, 4, 6, 7, 8, 9
			// unknown: 2, 3, 5
			val six = values.entries.first { it.value == 6 }.key
			val nine = values.entries.first { it.value == 9 }.key

			for (signalPattern in signalPatterns) {
				if (values[signalPattern] != -5) continue

				if (signalPattern.count { it in six } == 5) values[signalPattern] = 5
				else if (signalPattern.count { it in nine } == 5) values[signalPattern] = 3
				else values[signalPattern] = 2
			}

			// Calculate output
			outputValues.indices.fold(0) { acc, index ->
				acc + (10.0.pow(outputValues.size - index - 1).toInt() * values[outputValues[index]]!!)
			}.toInt()
		}
	}
}
