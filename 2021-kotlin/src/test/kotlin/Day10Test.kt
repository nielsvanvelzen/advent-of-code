import kotlin.test.Test
import kotlin.test.assertEquals

class Day10Test {
	private val sample by resource("day10_sample.txt")
	private val input by resource("day10_input.txt")

	@Test
	fun day10_part1_sample() {
		assertEquals(26397, Day10.runPart1(sample))
	}

	@Test
	fun day10_part1_input() {
		val answer = Day10.runPart1(input)
		println("Answer for day 10 part 1 is $answer")
	}

	@Test
	fun day10_part2_sample() {
		assertEquals(288957, Day10.runPart2(sample))
	}

	@Test
	fun day10_part2_input() {
		val answer = Day10.runPart2(input)
		println("Answer for day 10 part 2 is $answer")
	}
}
