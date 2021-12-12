object Day09 {
	fun runPart1(input: String): Int {
		val map = input.lines().map { it.map(Char::digitToInt) }

		val lowPoints = mutableListOf<Int>()
		for (x in map.indices) {
			for (y in map[x].indices) {
				val tile = map[x][y]

				val neighbours = listOfNotNull(
					if (x > 0) map[x - 1][y] else null,
					if (x < map.size - 1) map[x + 1][y] else null,
					if (y > 0) map[x][y - 1] else null,
					if (y < map[x].size - 1) map[x][y + 1] else null,
				)

				if (neighbours.all { it > tile }) lowPoints.add(tile)
			}
		}

		return lowPoints.sumOf { it + 1 }
	}

	fun runPart2(input: String): Int {
		val map = input.lines().map { it.map(Char::digitToInt) }

		fun calculateBasinSize(x: Int, y: Int): Int {
			val visited = mutableListOf<Pair<Int, Int>>()
			val inBasin = mutableListOf<Pair<Int, Int>>()

			fun visit(x: Int, y: Int) {
				val location = x to y
				if (location in visited) return

				visited.add(location)
				if (map[x][y] < 9) {
					inBasin.add(location)

					if (x > 0) visit(x - 1, y)
					if (x < map.size - 1) visit(x + 1, y)
					if (y > 0) visit(x, y - 1)
					if (y < map[x].size - 1) visit(x, y + 1)
				}
			}

			visit(x, y)

			return inBasin.size
		}

		val basins = mutableListOf<Int>()
		for (x in map.indices) {
			for (y in map[x].indices) {
				val tile = map[x][y]

				val neighbours = listOfNotNull(
					if (x > 0) map[x - 1][y] else null,
					if (x < map.size - 1) map[x + 1][y] else null,
					if (y > 0) map[x][y - 1] else null,
					if (y < map[x].size - 1) map[x][y + 1] else null,
				)

				if (neighbours.all { it > tile }) basins.add(calculateBasinSize(x, y))
			}
		}

		return basins.sortedDescending().take(3).fold(1) { acc, basin -> acc * basin }
	}
}
