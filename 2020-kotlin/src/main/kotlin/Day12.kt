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

	private fun parseActions(input: String) = input.lines().map {
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

	private fun runWaypoint(actions: List<Pair<Action, Int>>) {
		var waypointNorth = 1
		var waypointEast = 10
		var shipNorth = 0
		var shipEast = 0

		actions.forEach { (action, value) ->
			when (action) {
				Action.North -> waypointNorth += value
				Action.South -> waypointNorth -= value
				Action.East -> waypointEast += value
				Action.West -> waypointEast -= value
				Action.Left -> repeat(value / 90) {
					waypointEast = -waypointNorth.also { waypointNorth = waypointEast }
				}
				Action.Right -> repeat(value / 90) {
					waypointNorth = -waypointEast.also { waypointEast = waypointNorth }
				}
				Action.Forward -> {
					shipNorth += waypointNorth * value
					shipEast += waypointEast * value
				}
			}
		}

		println("abs(east($shipEast)) + abs(north($shipNorth)) = ${abs(shipEast) + abs(shipNorth)}")
	}

	private fun runFacing(actions: List<Pair<Action, Int>>) {
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

	fun run(input: String, waypoint: Boolean) {
		val actions = parseActions(input)

		if (waypoint) runWaypoint(actions)
		else runFacing(actions)
	}
}
