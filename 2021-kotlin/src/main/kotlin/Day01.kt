object Day01 {
	fun runPart1(input: String): Int {
		val heights = input.lines().map(String::toInt)
		return heights.indices.count { i -> i > 0 && heights[i] > heights[i - 1] }
	}

	fun runPart2(input: String): Int {
		val heights = input.lines().map(String::toInt)
		val windows = heights.indices.mapNotNull { i -> if (i > heights.size - 3) null else heights[i] + heights[i + 1] + heights[i + 2] }
		return windows.indices.count { i -> i > 0 && windows[i] > windows[i - 1] }
	}
}
