import kotlin.math.pow

object Day03 {
	fun runPart1(input: String): Int {
		val rows = input.lines()
		val width = rows.first().length
		val columns = IntArray(width) { 0 }

		for (row in rows) {
			for (i in row.indices) {
				if (row[i] == '1') columns[i]++
			}
		}

		var gamma = 0
		var epsilon = 0

		for (index in columns.indices) {
			val increment = 2.0.pow(width - index - 1).toInt()

			if (columns[index] > rows.size / 2) gamma += increment
			else epsilon += increment
		}

		return gamma * epsilon
	}

	fun runPart2(input: String): Int {
		val lines = input.lines()
		val height = lines.size
		val width = lines.first().length

		val bits = Array(height) { row ->
			BooleanArray(width) { column ->
				lines[row][column] == '1'
			}
		}

		val oxyRows = bits.copyOf().toMutableList()
		val scrubberRows = bits.copyOf().toMutableList()
		for (i in 0 until width) {
			if (oxyRows.size > 1) {
				val oxyCommon = oxyRows.count { it[i] }.toDouble() >= oxyRows.size / 2.0
				oxyRows.removeIf { it[i] != oxyCommon }
			}

			if (scrubberRows.size > 1) {
				val scrubberCommon = scrubberRows.count { it[i] }.toDouble() >= scrubberRows.size / 2.0
				scrubberRows.removeIf { it[i] == scrubberCommon }
			}
		}

		val oxygenRow = oxyRows.first()
		val scrubberRow = scrubberRows.first()
		var oxygenRating = 0
		var scrubberRating = 0

		for (index in 0 until width) {
			if (oxygenRow[index]) oxygenRating += 2.0.pow(width - index - 1).toInt()
			if (scrubberRow[index]) scrubberRating += 2.0.pow(width - index - 1).toInt()
		}

		return oxygenRating * scrubberRating
	}
}
