object Day05 {
	private fun calculate(input: String, seedParser: (String) -> Sequence<Long>): Long {
		var seeds: Sequence<Long>? = null
		val mappings = mutableListOf<Map<LongRange, Long>>()
		val currentMapping = mutableMapOf<LongRange, Long>()

		input.lineSequence()
			// Drop empty lines
			.forEach { line ->
				when {
					// Ignore empty lines
					line.isEmpty() -> Unit

					// Parse "seeds" header
					line.startsWith("seeds: ") -> {
						seeds = seedParser(line.split(": ")[1])
					}

					// Start new map
					line[0].isLetter() && line.endsWith(" map:") -> {
						// Save current mapping
						if (currentMapping.isNotEmpty()) mappings.add(currentMapping.toMap())
						currentMapping.clear()
					}

					// Append to map
					line[0].isDigit() -> {
						val (destinationRangeStart, sourceRangeStart, rangeLength) = line.split(' ').map(String::toLong)
						currentMapping[sourceRangeStart.rangeTo(sourceRangeStart + rangeLength)] = destinationRangeStart
					}
				}
			}

		mappings.add(currentMapping.toMap())

		val locations = requireNotNull(seeds).map { seed ->
			var mappedValue = seed

			for (mapping in mappings) {
				mapping@ for ((range, destinationStart) in mapping) {
					if (mappedValue in range) {
						mappedValue = mappedValue - range.first + destinationStart
						break@mapping
					}
				}
			}

			mappedValue
		}

		return locations.min()
	}

	fun runPart1(input: String): Long = calculate(input) { header ->
		header.split(' ').map(String::toLong).asSequence()
	}

	// This implementation is extremely slow because it will loop over ALL numbers in the seed ranges
	fun runPart2(input: String): Long = calculate(input) { header ->
		buildList {
			var a: Long? = null
			header.split(' ').forEach { part ->
				val value = part.toLong()
				if (a == null) {
					a = value
				} else {
					add(a!!..a!! + value)
					a = null
				}
			}
		}.asSequence().flatMap { it }
	}
}
