sealed class Instruction
data class RightInstruction(val amount: Int = 0) : Instruction()
data class DownInstruction(val amount: Int = 0) : Instruction()

object Day03 {
	const val TREE = '#'
	fun run(map: String, instructionTemplates: List<String>) {
		val totalTrees = mutableListOf<Long>()

		for (instructionTemplate in instructionTemplates) {
			val instructions = instructionTemplate.split(',').map(String::trim).map {
				val (command, amount) = it.split("\\s+".toRegex())
				when (command) {
					"right" -> RightInstruction(amount.toInt())
					"down" -> DownInstruction(amount.toInt())
					else -> TODO()
				}
			}

			val mapGrid = map.lines().map { it.toCharArray() }.toTypedArray()
			var x = 0
			var y = 0

			var trees = 0L
			while (true) {
				for (instruction in instructions) {
					when (instruction) {
						is RightInstruction -> y += instruction.amount
						is DownInstruction -> x += instruction.amount
					}
				}

				val pos = mapGrid[x].let { it[y % it.size] }
				if (pos == TREE) trees++

				// Bottom reached
				if (x >= mapGrid.size - 1) break
			}

			println("Ended up at ($x, $y) and encountered $trees trees")
			totalTrees += trees
		}

		println("${totalTrees.joinToString(" * ")} = ${totalTrees.reduce { acc, i -> acc * i }}")
	}
}
