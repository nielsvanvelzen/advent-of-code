import kotlin.test.Test
import kotlin.test.assertEquals

class Day07Test {
	private val sample by resource("day07_sample.txt")
	private val input by resource("day07_input.txt")

	@Test
	fun day7_part1_sample() {
		assertEquals(37, Day07.runPart1(sample))
	}

	@Test
	fun day7_part1_input() {
		val answer = Day07.runPart1(input)
		println("Answer for day 7 part 1 is $answer")
	}

	@Test
	fun day7_part2_sample() {
		assertEquals(168, Day07.runPart2(sample))
	}

	@Test
	fun day7_part2_input() {
		val answer = Day07.runPart2(input)
		println("Answer for day 7 part 2 is $answer")
	}
}
