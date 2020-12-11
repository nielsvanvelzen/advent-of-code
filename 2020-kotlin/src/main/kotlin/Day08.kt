object Day08 {
	fun run(input: String, terminateEarly: Boolean) {
		val instructions = input.lines().map {
			val instruction = it.substring(0 until 3)
			val argument = it.substring(4).toInt()

			instruction to argument
		}

		fun visit(
			instructions: List<Pair<String, Int>>,
			visited: Set<Int> = emptySet(),
			cursor: Int = 0,
			acc: Int = 0,
			modded: Boolean = false
		): Boolean {
			if (cursor >= instructions.size) {
				println("Ended with $acc")
				return true
			} else if (cursor in visited) {
				if (terminateEarly) println("Ended early with $acc")
				return terminateEarly
			}

			val (instruction, argument) = instructions[cursor]
			println("$instruction $argument | $cursor")

			return when (instruction) {
				"acc" -> visit(instructions, visited + cursor, cursor + 1, acc + argument, modded)
				"jmp" -> {
					var result = visit(instructions, visited + cursor, cursor + argument, acc, modded)

					if (!result && !modded)
						result = visit(instructions, visited + cursor, cursor + 1, acc, true)

					result
				}
				"nop" -> visit(instructions, visited + cursor, cursor + 1, acc, modded)
				else -> false
			}
		}

		visit(instructions)
	}
}
