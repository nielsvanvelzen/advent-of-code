import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {
	private val sample by resource("day01_sample.txt")
	private val sample2 by resource("day01_sample2.txt")
	private val input by resource("day01_input.txt")

	@Test
	fun day1_part1_sample() {
		assertEquals(142, Day01.runPart1(sample))
	}

	@Test
	fun day1_part1_input() {
		val answer = Day01.runPart1(input)
		println("Answer for day 1 part 1 is $answer")
	}

	@Test
	fun day1_part2_sample() {
		assertEquals(281, Day01.runPart2(sample2))
	}

	@Test
	fun day1_part2_input() {
		val answer = Day01.runPart2(input)
		println("Answer for day 1 part 2 is $answer")
	}
}
