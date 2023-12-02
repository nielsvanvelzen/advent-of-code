import kotlin.math.max

object Day02 {
	private data class GameDataSubset(val red: Int, val green: Int, val blue: Int)
	private data class GameData(val id: Int, val subsets: List<GameDataSubset>)

	private fun createGameData(input: String) = input.lineSequence()
		// Drop empty lines
		.filterNot { value -> value.isEmpty() }
		// Create GameData objects
		.map { game ->
			val (name, rawSubsets) = game.split(":")

			GameData(
				id = name.removePrefix("Game ").toInt(),
				subsets = rawSubsets.split(";").map { subset ->
					var red = 0
					var green = 0
					var blue = 0

					subset.trimStart().split(",").forEach { reveal ->
						if (reveal.endsWith("red")) red += reveal.trimStart().removeSuffix(" red").toInt()
						if (reveal.endsWith("green")) green += reveal.trimStart().removeSuffix(" green").toInt()
						if (reveal.endsWith("blue")) blue += reveal.trimStart().removeSuffix(" blue").toInt()
					}

					GameDataSubset(red, green, blue)
				},
			)
		}

	fun runPart1(input: String): Int {
		return createGameData(input)
			.filter { game ->
				game.subsets.none { subset ->
					subset.red > 12 || subset.green > 13 || subset.blue > 14
				}
			}
			.map { it.id }
			// Sum
			.sum()
	}

	fun runPart2(input: String): Int {
		return createGameData(input)
			.map { game ->
				var minRed = 0
				var minGreen = 0
				var minBlue = 0

				game.subsets.forEach { subset ->
					minRed = max(subset.red, minRed)
					minGreen = max(subset.green, minGreen)
					minBlue = max(subset.blue, minBlue)
				}

				minRed * minGreen * minBlue
			}
			// Sum
			.sum()
	}
}
