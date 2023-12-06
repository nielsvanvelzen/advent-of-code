object Day06 {
	fun runPart1(input: String): Int {
		val lines = input.lines()
		val times = lines[0].split(':')[1].trimStart().split(' ').mapNotNull(String::toIntOrNull)
		val distances = lines[1].split(':')[1].trimStart().split(' ').mapNotNull(String::toIntOrNull)

		return times.mapIndexed { gameIndex, time ->
			var beatablePressTimes = 0

			for (pressTime in 0..time) {
				val distance = (time - pressTime) * pressTime
				if (distance > distances[gameIndex]) beatablePressTimes++
				else if (beatablePressTimes > 0) break
			}

			beatablePressTimes
		}.reduce { acc, i -> acc * i }
	}

	fun runPart2(input: String): Int {
		val lines = input.lines()
		val time = lines[0].split(':')[1].replace(" ", "").toLong()
		val bestDistance = lines[1].split(':')[1].replace(" ", "").toLong()

		var beatablePressTimes = 0

		for (pressTime in 0L..time) {
			val distance = (time - pressTime) * pressTime
			if (distance > bestDistance) beatablePressTimes++
			else if (beatablePressTimes > 0) break
		}

		return beatablePressTimes
	}
}
