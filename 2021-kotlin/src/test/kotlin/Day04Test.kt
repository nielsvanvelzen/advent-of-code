import kotlin.test.Test
import kotlin.test.assertEquals

class Day04Test {
	private val sample by resource("day04_sample.txt")
	private val input by resource("day04_input.txt")

	@Test
	fun day4_part1_sample() {
		assertEquals(4512, Day04.runPart1(sample))
	}

	@Test
	fun day4_part1_input() {
		val answer = Day04.runPart1(input)
		println("Answer for day 4 part 1 is $answer")
	}

	@Test
	fun day4_part2_sample() {
		assertEquals(1924, Day04.runPart2(sample))
	}

	@Test
	fun day4_part2_input() {
		val answer = Day04.runPart2(input)
		println("Answer for day 4 part 2 is $answer")
	}
}
