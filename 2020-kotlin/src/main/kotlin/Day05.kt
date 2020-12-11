object Day05 {
	fun run(input: String) {
		val all = mutableListOf<Int>()

		for (pass in input.lines()) {
			var row = -1
			var column = -1

			var rowRange = 0..127
			var columnRange = 0..7
			for (char in pass) {
				val rowDiff = rowRange.last - rowRange.first
				val columnDiff = columnRange.last - columnRange.first

				when (char) {
					'F' -> rowRange = rowRange.first until rowRange.last - rowDiff / 2
					'B' -> rowRange = rowRange.first + rowDiff / 2 + 1..rowRange.last
					'L' -> columnRange = columnRange.first until columnRange.last - columnDiff / 2
					'R' -> columnRange = columnRange.first + columnDiff / 2 + 1..columnRange.last
				}

				// I know...
				if (rowRange.first == rowRange.last) row = rowRange.first
				if (columnRange.first == columnRange.last) column = columnRange.first
			}

			val id = row * 8 + column
			println("$pass: id $id, row $row, column $column")

			all += id
		}


		val mine = (all.minOrNull()!!..all.maxOrNull()!!).filterNot(all::contains)

		println("Highest id: ${all.maxOrNull()}")
		if (mine.size == 1) println("My seat: ${mine.first()}")
		else println("Could not find my seat!")
	}
}
