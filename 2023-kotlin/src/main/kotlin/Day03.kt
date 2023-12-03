import kotlin.math.max
import kotlin.math.min

object Day03 {
	private fun createGrid(input: String) = input.lines()
		// Drop empty lines
		.filterNot { value -> value.isEmpty() }
		// Create subarrays
		.map { line -> line.toCharArray() }
		// Return as Array<CharArray>
		.toTypedArray()

	fun runPart1(input: String): Int {
		val grid = createGrid(input)

		val symbolAdjacentNumbers = mutableListOf<Int>()
		grid.indices.forEach { x ->
			var y = 0
			while (y < grid[x].size) {
				val char = grid[x][y]
				var number: String? = null

				if (char.isDigit()) {
					number = buildString {
						for (ny in y..<grid[x].size) {
							var nc = grid[x][ny]
							if (nc.isDigit()) append(nc)
							else break
						}
					}
				}

				if (number != null) {
					var valid = false
					for (cx in max(0, x - 1)..min(x + 1, grid.size - 1)) {
						for (cy in max(0, y - 1)..min(y + number.length, grid[cx].size - 1)) {
							val cc = grid[cx][cy]
							if (!cc.isDigit() && cc != '.') {
								valid = true
								break
							}
						}
						if (valid) break
					}

					if (valid) symbolAdjacentNumbers.add(number.toInt())
				}

				y += number?.length ?: 1
			}
		}

		return symbolAdjacentNumbers.sum()
	}

	fun runPart2(input: String): Int {
		val grid = createGrid(input)

		// Map<GearPosition, AdjacentNumbers>
		val gears = mutableMapOf<Pair<Int, Int>, MutableList<Int>>()

		grid.indices.forEach { x ->
			var y = 0
			while (y < grid[x].size) {
				val char = grid[x][y]
				var number: String? = null

				if (char.isDigit()) {
					number = buildString {
						for (ny in y..<grid[x].size) {
							var nc = grid[x][ny]
							if (nc.isDigit()) append(nc)
							else break
						}
					}
				}

				if (number != null) {
					for (cx in max(0, x - 1)..min(x + 1, grid.size - 1)) {
						for (cy in max(0, y - 1)..min(y + number.length, grid[cx].size - 1)) {
							val cc = grid[cx][cy]
							if (cc == '*') {
								gears.getOrPut(cx to cy, ::mutableListOf).add(number.toInt())
							}
						}
					}
				}

				y += number?.length ?: 1
			}
		}

		// Calculate gear ratios
		return gears
			// Only use gears that have two or more numbers adjacent
			.filter { it.value.size > 1 }
			// Multiply all values (could be easier as there should only be 2 🤷‍♂️)
			.map { it.value.reduce { acc, i -> acc * i } }.sum()
	}
}
