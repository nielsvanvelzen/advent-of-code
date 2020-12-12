import kotlin.math.abs

object Day12 {
	enum class Action {
		North,
		South,
		East,
		West,
		Left,
		Right,
		Forward,
	}

	fun run(input: String) {
		val actions = input.lines().map {
			val action = it[0]
			val value = it.substring(1)

			when (action) {
				'N' -> Action.North
				'S' -> Action.South
				'E' -> Action.East
				'W' -> Action.West
				'L' -> Action.Left
				'R' -> Action.Right
				'F' -> Action.Forward
				else -> TODO()
			} to value.toInt()
		}

		var north = 0
		var east = 0
		var facing = 90

		actions.forEach { (action, value) ->
			when (action) {
				Action.North -> north += value
				Action.South -> north -= value
				Action.East -> east += value
				Action.West -> east -= value
				Action.Left -> facing -= value
				Action.Right -> facing += value
				Action.Forward -> when (facing % 360) {
					0 -> north += value
					90 -> east += value
					180 -> north -= value
					270 -> east -= value
				}
			}
		}

		println("abs(east($east)) + abs(north($north)) = ${abs(east) + abs(north)}")
	}
}
