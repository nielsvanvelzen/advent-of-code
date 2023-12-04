object Day04 {
	private fun readCards(input: String) = input.lineSequence()
		// Drop empty lines
		.filterNot { value -> value.isEmpty() }
		.map { card ->
			val (winningNumbers, myNumbers) = card
				.split(':')[1]
				.split('|')
				.map { section ->
					section
						.trim()
						.split(' ')
						.filterNot { number -> number.isBlank() }
						.map { number -> number.trimStart().toInt() }
						.toSet()
				}

			winningNumbers to myNumbers
		}

	fun runPart1(input: String): Int = readCards(input).map { (winningNumbers, myNumbers) ->
		val myWinningNumbers = myNumbers.intersect(winningNumbers)
		myWinningNumbers.fold(0) { acc, i -> if (acc == 0) 1 else acc * 2 }
	}.sum()

	fun runPart2(input: String): Int {
		val cards = readCards(input).toList()

		// This is really slow but good enough for now, ideally we'd process the cards backwards and keep a cache of
		// their results to reduce lookups by a lot

		fun validateCard(index: Int = 0): Int {
			val (winningNumbers, myNumbers) = cards[index]
			val myWinningNumbers = myNumbers.intersect(winningNumbers)

			var additionalCardCount = myWinningNumbers.size

			for (i in index + 1..index + myWinningNumbers.size) {
				additionalCardCount += validateCard(i)
			}

			return additionalCardCount
		}

		return List(cards.size) { index -> 1 + validateCard(index) }.sum()
	}
}
