import kotlin.test.Test
import kotlin.test.assertEquals

class Day09Test {
	private val sample by resource("day09_sample.txt")
	private val input by resource("day09_input.txt")

	@Test
	fun day9_part1_sample() {
		assertEquals(15, Day09.runPart1(sample))
	}

	@Test
	fun day9_part1_input() {
		val answer = Day09.runPart1(input)
		println("Answer for day 9 part 1 is $answer")
	}

	@Test
	fun day9_part2_sample() {
		assertEquals(1134, Day09.runPart2(sample))
	}

	@Test
	fun day9_part2_input() {
		val answer = Day09.runPart2(input)
		println("Answer for day 9 part 2 is $answer")
	}
}
