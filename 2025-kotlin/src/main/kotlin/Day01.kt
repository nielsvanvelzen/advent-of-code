object Day01 {
	fun runPart1(input: String): Int {
		val rotations = input.lineSequence()
			// Drop empty lines
			.filterNot { value -> value.isEmpty() }
			// Get delta
			.map { value ->
				val delta = value.substring(1).toInt()
				if (value[0] == 'L') -delta else delta
			}

		var current = 50
		var hitZero = 0

		for (delta in rotations) {
			current += delta

			while (current > 99) current -= 100
			while (current < 0) current += 100

			if (current == 0) hitZero++
			println("Turned $delta to $current (zeroes hit $hitZero)")
		}

		return hitZero
	}

	fun runPart2(input: String): Int {
		val rotations = input.lineSequence()
			// Drop empty lines
			.filterNot { value -> value.isEmpty() }
			// Get delta
			.map { value ->
				val delta = value.substring(1).toInt()
				if (value[0] == 'L') -delta else delta
			}

		var current = 50
		var hitZero = 0

		for (delta in rotations) {
			if (current == 0 && delta < 0) hitZero--
			current += delta
			hitZero += if (delta >= 0) current / 100 else (-current + 100) / 100
			current = current.mod(100)

			println("Turned $delta to $current (zeroes hit $hitZero)")
		}

		return hitZero
	}
}
