object Day05 {
	data class Line(
		val x1: Int,
		val y1: Int,
		val x2: Int,
		val y2: Int,
	) {
		fun points(allowDiagonal: Boolean): List<Pair<Int, Int>> {
			val xRange = (if (x1 <= x2) x1..x2 else x1 downTo x2).toList()
			val yRange = (if (y1 <= y2) y1..y2 else y1 downTo y2).toList()

			return when {
				x1 == x2 -> yRange.map { y -> x1 to y }
				y1 == y2 -> xRange.map { x -> x to y1 }
				allowDiagonal -> {
					val points = mutableListOf<Pair<Int, Int>>()
					for (i in xRange.indices) {
						points.add(xRange[i] to yRange[i])
					}
					points
				}
				else -> emptyList()
			}
		}
	}

	fun run(input: String, allowDiagonal: Boolean): Int {
		val regex = Regex("""^(\d+),(\d+)\s->\s(\d+),(\d+)$""")
		var width = 0
		var height = 0

		val lines = input.lines().map {
			val (x1, y1, x2, y2) = regex.matchEntire(it)!!.groupValues.takeLast(4).map(String::toInt)
			width = maxOf(width, x1, x2)
			height = maxOf(height, y1, y2)
			Line(x1, y1, x2, y2)
		}

		// Create map of height * width with 0 as default value
		val map = Array(height + 1) {
			Array(width + 1) { 0 }
		}

		// Mark overlap in map
		for (line in lines) {
			for ((x, y) in line.points(allowDiagonal)) {
				map[y][x]++
			}
		}

		// Map printing
//		for (x in map) {
//			for (y in x) {
//				if (y == 0) print(".")
//				else print(y)
//			}
//			println()
//		}

		// Count overlapping tiles
		return map.sumOf { x -> x.count { y -> y >= 2 } }
	}

	fun runPart1(input: String): Int = run(input, false)
	fun runPart2(input: String): Int = run(input, true)
}
