import kotlin.test.Test
import kotlin.test.assertEquals

class Day02Test {
	private val sample by resource("day02_sample.txt")
	private val input by resource("day02_input.txt")

	@Test
	fun day2_part1_sample() {
		assertEquals(150, Day02.runPart1(sample))
	}

	@Test
	fun day2_part1_input() {
		val answer = Day02.runPart1(input)
		println("Answer for day 2 part 1 is $answer")
	}

	@Test
	fun day2_part2_sample() {
		assertEquals(900, Day02.runPart2(sample))
	}

	@Test
	fun day2_part2_input() {
		val answer = Day02.runPart2(input)
		println("Answer for day 2 part 2 is $answer")
	}
}
