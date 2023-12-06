import kotlin.test.Test
import kotlin.test.assertEquals

class Day06Test {
	private val sample by resource("day06_sample.txt")
	private val input by resource("day06_input.txt")

	@Test
	fun day6_part1_sample() {
		assertEquals(288, Day06.runPart1(sample))
	}

	@Test
	fun day6_part1_input() {
		val answer = Day06.runPart1(input)
		println("Answer for day 6 part 1 is $answer")
	}

	@Test
	fun day6_part2_sample() {
		assertEquals(71503, Day06.runPart2(sample))
	}

	@Test
	fun day6_part2_input() {
		val answer = Day06.runPart2(input)
		println("Answer for day 6 part 2 is $answer")
	}
}
