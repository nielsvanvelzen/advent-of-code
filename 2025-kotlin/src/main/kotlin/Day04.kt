object Day04 {
	fun runPart1(input: String): Long {
		val diagram = input
			.lineSequence()
			.map { row -> row.toCharArray() }
			.toList()

		val width = diagram.first().size
		val height = diagram.size

		var accessible = 0L

		for (x in 0 until width) {
			for (y in 0 until height) {
				val isRollOfPaper = diagram[x][y] == '@'
				if (!isRollOfPaper) continue

				var neighbouringRollsOfPaper = 0
				for (neighbourX in x - 1..x + 1) {
					if (neighbourX !in 0 until width) continue

					for (neighbourY in y - 1..y + 1) {
						if (neighbourY !in 0 until height) continue
						if (neighbourX == x && neighbourY == y) continue

						val isRollOfPaper = diagram[neighbourX][neighbourY] == '@'
						if (isRollOfPaper) neighbouringRollsOfPaper++
					}
				}

				if (neighbouringRollsOfPaper < 4) accessible++
			}
		}

		return accessible
	}

	fun runPart2(input: String): Long {
		val diagram = input
			.lineSequence()
			.map { row -> row.toCharArray() }
			.toList()

		val width = diagram.first().size
		val height = diagram.size

		fun step(): Long {
			var removed = 0L

			for (x in 0 until width) {
				for (y in 0 until height) {
					val isRollOfPaper = diagram[x][y] == '@'
					if (!isRollOfPaper) continue

					var neighbouringRollsOfPaper = 0
					for (neighbourX in x - 1..x + 1) {
						if (neighbourX !in 0 until width) continue

						for (neighbourY in y - 1..y + 1) {
							if (neighbourY !in 0 until height) continue
							if (neighbourX == x && neighbourY == y) continue

							val isRollOfPaper = diagram[neighbourX][neighbourY] == '@' || diagram[neighbourX][neighbourY] == 'x'
							if (isRollOfPaper) neighbouringRollsOfPaper++
						}
					}

					if (neighbouringRollsOfPaper < 4) {
						diagram[x][y] = 'x'
						removed++
					}
				}
			}

			// Now actually remove
			for (x in 0 until width) {
				for (y in 0 until height) {
					if (diagram[x][y] == 'x') diagram[x][y] = '.'
				}
			}

			return removed
		}

		var totalRemoved = 0L
		while (true) {
			val removed = step()
			if (removed == 0L) break
			totalRemoved += removed
		}

		return totalRemoved
	}
}
