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
}
