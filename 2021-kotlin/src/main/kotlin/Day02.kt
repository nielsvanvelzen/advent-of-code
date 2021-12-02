object Day02 {
	fun runPart1(input: String): Int {
		val instructions = input.lines().map {
			val (command, value) = it.split(" ")
			command to value.toInt()
		}

		var horizontalPosition = 0
		var depth = 0

		for ((command, value) in instructions) {
			when (command) {
				"forward" -> horizontalPosition += value
				"down" -> depth += value
				"up" -> depth -= value
			}
		}

		return horizontalPosition * depth
	}

	fun runPart2(input: String): Int {
		val instructions = input.lines().map {
			val (command, value) = it.split(" ")
			command to value.toInt()
		}

		var horizontalPosition = 0
		var depth = 0
		var aim = 0

		for ((command, value) in instructions) {
			when (command) {
				"down" -> aim += value
				"up" -> aim -= value
				"forward" -> {
					horizontalPosition += value
					depth += aim * value
				}
			}
		}

		return horizontalPosition * depth
	}
}
