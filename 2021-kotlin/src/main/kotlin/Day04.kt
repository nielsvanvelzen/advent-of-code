object Day04 {
	class BingoCard {
		companion object {
			const val WIDTH = 5
			const val HEIGHT = 5
		}

		val numbers = Array(WIDTH * HEIGHT) { 0 to false }

		fun get(row: Int, column: Int) = numbers[row * HEIGHT + column]
		fun setNum(row: Int, column: Int, value: Int) {
			numbers[row * HEIGHT + column] = value to false
		}

		fun setMark(number: Int): Boolean {
			var changes = false

			for (index in numbers.indices) {
				if (numbers[index].first == number) {
					numbers[index] = number to true

					changes = true
				}
			}

			return changes
		}

		fun checkBingo(): Boolean {
			for (x in 0 until HEIGHT) {
				var rowSet = true

				for (y in 0 until WIDTH) {
					if (!numbers[x * HEIGHT + y].second) rowSet = false
				}

				if (rowSet) return true
			}

			for (y in 0 until WIDTH) {
				var columnSet = true

				for (x in 0 until HEIGHT) {
					if (!numbers[x * HEIGHT + y].second) columnSet = false
				}

				if (columnSet) return true
			}

			return false
		}

		fun sumUnmarked() = numbers.filterNot { it.second }.sumOf { it.first }

		override fun toString(): String = numbers.joinToString(", ")
	}

	fun runPart1(input: String): Int {
		val lines = input.lineSequence().iterator()

		// Numbers for each round
		val roundNumbers = lines.next().split(",").map(String::toInt)
		val cards = mutableSetOf<BingoCard>()

		var currentCardRow = 0
		var currentCard = BingoCard()
		while (lines.hasNext()) {
			val line = lines.next()
			if (line.isBlank()) continue

			line.split(' ').filterNot { it.isBlank() }.map(String::toInt).forEachIndexed { index, i ->
				currentCard.setNum(currentCardRow, index, i)
			}

			currentCardRow++
			if (currentCardRow >= BingoCard.HEIGHT) {
				cards.add(currentCard)
				currentCard = BingoCard()
				currentCardRow = 0
			}
		}

		var bingo: BingoCard? = null
		var round = 0
		var number = 0
		while (bingo == null) {
			number = roundNumbers[round]

			for (card in cards) {
				val changed = card.setMark(number)
				if (changed && card.checkBingo()) {
					bingo = card
					break
				}
			}

			round++
		}

		return bingo.sumUnmarked() * number
	}

	fun runPart2(input: String): Int {
		val lines = input.lineSequence().iterator()

		// Numbers for each round
		val roundNumbers = lines.next().split(",").map(String::toInt)
		val cards = mutableListOf<BingoCard>()

		var currentCardRow = 0
		var currentCard = BingoCard()
		while (lines.hasNext()) {
			val line = lines.next()
			if (line.isBlank()) continue

			line.split(' ').filterNot { it.isBlank() }.map(String::toInt).forEachIndexed { index, i ->
				currentCard.setNum(currentCardRow, index, i)
			}

			currentCardRow++
			if (currentCardRow >= BingoCard.HEIGHT) {
				cards.add(currentCard)
				currentCard = BingoCard()
				currentCardRow = 0
			}
		}

		var bingo: BingoCard? = null
		var round = 0
		var number = 0
		while (bingo == null) {
			number = roundNumbers[round]

			for (i in cards.indices.reversed()) {
				val card = cards[i]

				val changed = card.setMark(number)
				if (changed && card.checkBingo()) {
					if (cards.size == 1) bingo = card
					cards.removeAt(i)
				}
			}

			round++
		}
		println("$round $number ${bingo.sumUnmarked()}")

		return bingo.sumUnmarked() * number
	}
}
