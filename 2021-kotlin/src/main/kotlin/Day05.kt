import kotlin.math.max
import kotlin.math.min

object Day05 {
	data class Line(
		val x1: Int,
		val y1: Int,
		val x2: Int,
		val y2: Int,
	) {
		val points by lazy {
			if (x1 == x2) (min(y1, y2)..max(y1, y2)).map { x1 to it }
			else if (y1 == y2) (min(x1, x2)..max(x1, x2)).map { it to y1 }
			else emptyList()
		}
	}

	fun runPart1(input: String): Int {
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
			for ((x, y) in line.points) {
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
}
