import kotlin.math.abs

object Day13 {
	fun run(input: String) {
		val (rawPreferredDeparture, rawBusDepartures) = input.lines()
		val preferredDeparture = rawPreferredDeparture.toInt()

		var preferredBus = Pair(-1, -1)

		val busDepartures = rawBusDepartures.split(",").mapNotNull {
			if (it == "x") null
			else it.toInt()
		}

		busDepartures.forEach { initialBusDeparture ->
			var last = initialBusDeparture

			while (last < preferredDeparture) {
				last += initialBusDeparture
			}

			val diff = abs(last - preferredDeparture)
			if (preferredBus.first == -1 || diff < preferredBus.second) {
				preferredBus = Pair(initialBusDeparture, diff)
			}
		}

		println(preferredBus.first * preferredBus.second)
	}
}
