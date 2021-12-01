object Day01 {
	fun runPart1(input: String): Int {
		val heights = input.lines().map(String::toInt)
		return heights.indices.count { i -> i > 0 && heights[i] > heights[i - 1] }
	}
}
