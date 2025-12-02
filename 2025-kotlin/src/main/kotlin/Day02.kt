object Day02 {
	fun runPart1(input: String): Long {
		val ranges = input.split(',')
		val ids = ranges.flatMap { range ->
			val (start, end) = range.split('-').map(String::toLong)
			start..end
		}

		val invalidIds = ids
			// Use string operations to find invalid ids
			.map(Long::toString)
			// Identifier must be of even width
			.filter { it.length % 2 == 0 }
			// First half must be equal to second half
			.filter { it.take(it.length / 2) == it.substring(it.length / 2) }

		// Sum all invalid ids
		return invalidIds.sumOf { it.toLong() }
	}

	fun runPart2(input: String): Long {
		val ranges = input.split(',')
		val ids = ranges.flatMap { range ->
			val (start, end) = range.split('-').map(String::toLong)
			start..end
		}

		val invalidIds = ids
			// Use string operations to find invalid ids
			.map(Long::toString)
			// Find invalid ids
			.filterNot {
				// Find possible chunks based on identifier size
				for (chunkSize in 1..(it.length / 2)) {
					// Get chunks based on current chunk size
					val chunks = it.chunked(chunkSize)

					// If the last chunk is not expected length we can skip checking this one
					if (chunks.last().length != chunkSize) continue

					// If any of the chunks differ the identifier is invalid
					if (chunks.all { chunk -> chunk == chunks.first() }) return@filterNot false
				}

				// No invalid parts found in identifier
				true
			}

		// Sum all invalid ids
		return invalidIds.sumOf { it.toLong() }
	}
}
