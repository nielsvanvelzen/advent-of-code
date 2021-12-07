import kotlin.test.Test
import kotlin.test.assertEquals

class Day03Test {
	private val sample by resource("day03_sample.txt")
	private val input by resource("day03_input.txt")

	@Test
	fun day3_part1_sample() {
		assertEquals(198, Day03.runPart1(sample))
	}

	@Test
	fun day3_part1_input() {
		val answer = Day03.runPart1(input)
		println("Answer for day 3 part 1 is $answer")
	}

	@Test
	fun day3_part2_sample() {
		assertEquals(230, Day03.runPart2(sample))
	}

	@Test
	fun day3_part2_input() {
		val answer = Day03.runPart2(input)
		println("Answer for day 3 part 2 is $answer")
	}
}
