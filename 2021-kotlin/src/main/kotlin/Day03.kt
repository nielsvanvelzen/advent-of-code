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
}
