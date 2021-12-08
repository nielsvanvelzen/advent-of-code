import kotlin.math.abs

object Day07 {
	fun runPart1(input: String): Int {
		val positions = input.split(",").map(String::toInt)

		val min = positions.minOrNull() ?: 0
		val max = positions.maxOrNull() ?: 1

		return (min..max).minOf { target ->
			positions.sumOf { abs(it - target) }
		}
	}

	fun runPart2(input: String): Int {
		val positions = input.split(",").map(String::toInt)

		val min = positions.minOrNull() ?: 0
		val max = positions.maxOrNull() ?: 1

		return (min..max).minOf { target ->
			positions.sumOf {
				val diff = abs(it - target)
				diff * (diff + 1) / 2
			}
		}
	}
}
