object Day06 {
	fun run(input: String, days: Int): Long {
		val ages = mutableMapOf(
			0 to 0L,
			1 to 0L,
			2 to 0L,
			3 to 0L,
			4 to 0L,
			5 to 0L,
			6 to 0L,
			7 to 0L,
			8 to 0L,
		)
		input.split(",").map(String::toInt).forEach {
			ages[it] = ages[it]!! + 1L
		}

		repeat(days) {
			val z = ages[0]!!
			ages[0] = ages[1]!!
			ages[1] = ages[2]!!
			ages[2] = ages[3]!!
			ages[3] = ages[4]!!
			ages[4] = ages[5]!!
			ages[5] = ages[6]!!
			ages[6] = ages[7]!! + z
			ages[7] = ages[8]!!
			ages[8] = z
		}

		return ages.values.sum()
	}

	fun runPart1(input: String): Long = run(input, 80)
	fun runPart2(input: String): Long = run(input, 256)
}
