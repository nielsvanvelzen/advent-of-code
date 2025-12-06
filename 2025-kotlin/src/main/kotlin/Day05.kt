import kotlin.math.max

object Day05 {
	fun runPart1(input: String): Int {
		val (rawFreshIngredientRanges, rawAvailableIngredients) = input
			.split("\n\n")

		val freshIngredientRanges = rawFreshIngredientRanges
			.lines()
			.map {
				val (start, end) = it.split('-').map(String::toLong)
				start..end
			}

		val availableIngredients = rawAvailableIngredients
			.lines()
			.map(String::toLong)

		val freshIngredients = availableIngredients.filter { ingredient -> freshIngredientRanges.any { ingredient in it } }

		return freshIngredients.size
	}

	fun runPart2(input: String): Long {
		val freshIngredientRanges = input
			.split("\n\n")
			.first()
			.lines()
			.map {
				val (start, end) = it.split('-').map(String::toLong)
				start..end
			}
			.sortedBy { it.first }

		var previousRange: LongRange? = null
		val deduplicatedRanges = freshIngredientRanges.mapNotNull { range ->
			val newRange = when {
				previousRange == null -> range
				range.last <= previousRange.last -> null
				else -> max(range.first, previousRange.last + 1)..range.last
			}
			if (newRange != null) previousRange = newRange
			newRange
		}

		return deduplicatedRanges.sumOf { it.last - it.first + 1 }
	}
}
