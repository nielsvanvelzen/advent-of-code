object Day10 {
	fun runPart1(input: String): Long {
		val lines = input.lines()

		fun parseLine(line: String): Int {
			val stack = ArrayDeque<Char>()
			for (index in line.indices) {
				when (val char = line[index]) {
					// Open
					'(' -> stack.add(')')
					'[' -> stack.add(']')
					'{' -> stack.add('}')
					'<' -> stack.add('>')
					// Close
					')', ']', '}', '>' -> if (stack.last() != char) return index else stack.removeLast()
				}
			}
			return -1
		}

		return lines.sumOf { line ->
			when (val errorAt = parseLine(line)) {
				-1 -> 0
				else -> when (line[errorAt]) {
					')' -> 3
					']' -> 57
					'}' -> 1197
					'>' -> 25137
					else -> 0
				}
			}.toLong()
		}
	}

	fun runPart2(input: String): Long {
		val lines = input.lines()

		fun parseLine(line: String): Long? {
			val stack = ArrayDeque<Char>()
			for (index in line.indices) {
				when (val char = line[index]) {
					// Open
					'(' -> stack.add(')')
					'[' -> stack.add(']')
					'{' -> stack.add('}')
					'<' -> stack.add('>')
					// Close
					')', ']', '}', '>' -> if (stack.last() != char) return null else stack.removeLast()
				}
			}

			return stack.reversed().fold(0L) { acc, char ->
				acc * 5 + when (char) {
					')' -> 1
					']' -> 2
					'}' -> 3
					'>' -> 4
					else -> 0
				}
			}
		}

		return lines.mapNotNull(::parseLine).sorted().run {
			get(size / 2)
		}
	}
}
