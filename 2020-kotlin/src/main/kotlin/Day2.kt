object Day2 {
	private val regex = "^(\\d+)-(\\d+)\\s+(.):\\s+(.*?)\$".toRegex()

	private data class Policy(val range: IntRange, val letter: Char, val password: String)

	fun run(input: String) {
		val policies = input.split("\n").map {
			val values = regex.matchEntire(it)!!.groupValues
			val range = values[1].toInt()..values[2].toInt()
			val letter = values[3].toCharArray().first()
			val password = values[4]

			Policy(range, letter, password)
		}

		val validPasswords = policies.count { policy ->
			policy.password.count { it == policy.letter } in policy.range
		}

		println("Valid passwords: $validPasswords")
	}

	fun runPart2(input: String) {
		val policies = input.split("\n").map {
			val values = regex.matchEntire(it)!!.groupValues
			val range = values[1].toInt()..values[2].toInt()
			val letter = values[3].toCharArray().first()
			val password = values[4]

			Policy(range, letter, password)
		}

		val validPasswords = policies.count { policy ->
			val matchA = policy.password[policy.range.first - 1] == policy.letter
			val matchB = policy.password[policy.range.last - 1] == policy.letter
			println("$policy, $matchA, $matchB")

			if (matchA != matchB) matchA || matchB else false
		}

		println("Valid passwords: $validPasswords")
	}
}
