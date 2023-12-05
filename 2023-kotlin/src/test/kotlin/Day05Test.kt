import kotlin.test.Test
import kotlin.test.assertEquals

class Day05Test {
	private val sample by resource("day05_sample.txt")
	private val input by resource("day05_input.txt")

	@Test
	fun day5_part1_sample() {
		assertEquals(35, Day05.runPart1(sample))
	}

	@Test
	fun day5_part1_input() {
		val answer = Day05.runPart1(input)
		println("Answer for day 5 part 1 is $answer")
	}

	@Test
	fun day5_part2_sample() {
		assertEquals(46, Day05.runPart2(sample))
	}

	@Test
	fun day5_part2_input() {
		val answer = Day05.runPart2(input)
		println("Answer for day 5 part 2 is $answer")
	}
}
