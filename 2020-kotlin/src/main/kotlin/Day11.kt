object Day11 {
	enum class Seat {
		Empty,
		Occupied,
		Floor;

		override fun toString(): String = when (this) {
			Empty -> "L"
			Occupied -> "#"
			Floor -> "."
		}
	}

	// Helper function
	private fun printMap(map: List<List<Seat>>) {
		map.forEach { row ->
			row.forEach { seat ->
				print(seat.toString())
			}
			println()
		}
	}

	private fun findSeat(
		position: Pair<Int, Int>,
		map: List<List<Seat>>,
		incrementRow: Int,
		incrementSeat: Int
	): Seat? {
		var (x, y) = position

		while (true) {
			x += incrementRow
			y += incrementSeat

			val seat = map.getOrNull(x)?.getOrNull(y) ?: return null
			if (seat != Seat.Floor) return seat
		}
	}

	private fun getAdjacentSeats(position: Pair<Int, Int>, map: List<List<Seat>>, extendedRules: Boolean): List<Seat> {
		val (x, y) = position

		return if (extendedRules) {
			listOfNotNull(
				findSeat(position, map, -1, -1),
				findSeat(position, map, -1, 0),
				findSeat(position, map, -1, +1),
				findSeat(position, map, 0, -1),
				findSeat(position, map, 0, 1),
				findSeat(position, map, 1, -1),
				findSeat(position, map, 1, 0),
				findSeat(position, map, 1, 1),
			)
		} else {
			listOfNotNull(
				map.getOrNull(x - 1)?.getOrNull(y - 1),
				map.getOrNull(x - 1)?.getOrNull(y),
				map.getOrNull(x - 1)?.getOrNull(y + 1),
				map.getOrNull(x)?.getOrNull(y - 1),
				map.getOrNull(x)?.getOrNull(y + 1),
				map.getOrNull(x + 1)?.getOrNull(y - 1),
				map.getOrNull(x + 1)?.getOrNull(y),
				map.getOrNull(x + 1)?.getOrNull(y + 1),
			)
		}
	}

	private fun visitMap(map: List<List<Seat>>, extendedRules: Boolean): Pair<Boolean, List<List<Seat>>> {
		val newMap = mutableListOf<MutableList<Seat>>()
		var changed = false

		map.forEachIndexed { rowIndex, row ->
			val newRow = mutableListOf<Seat>()

			row.forEachIndexed { seatIndex, seat ->
				val adjacent = getAdjacentSeats(rowIndex to seatIndex, map, extendedRules)

				val newSeat = when {
					seat == Seat.Empty && adjacent.all { it != Seat.Occupied } -> Seat.Occupied
					seat == Seat.Occupied && adjacent.count { it == Seat.Occupied } >= if (extendedRules) 5 else 4 -> Seat.Empty
					else -> seat
				}

				if (newSeat != seat) changed = true

				newRow.add(newSeat)
			}

			newMap.add(newRow)
		}

		return changed to newMap
	}

	fun run(input: String, extendedRules: Boolean) {
		var map = input.lines().map { row ->
			row.toCharArray().map { column ->
				when (column) {
					'L' -> Seat.Empty
					'#' -> Seat.Occupied
					'.' -> Seat.Floor
					else -> TODO()
				}
			}
		}

		var iteration = 0
		while (true) {
			val (changed, newMap) = visitMap(map, extendedRules)
			if (!changed) break

			iteration++
			map = newMap
//			println("Iteration $iteration")
//			printMap(map)
		}

		val occupied = map.map { row -> row.count { seat -> seat == Seat.Occupied } }.sum()

		println("iterations $iteration occupied $occupied")
	}
}
