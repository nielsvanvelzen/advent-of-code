import kotlin.test.Test
import kotlin.test.assertEquals

class Day08Test {
	private val sample by resource("day08_sample.txt")
	private val input by resource("day08_input.txt")

	@Test
	fun day8_part1_sample() {
		assertEquals(26, Day08.runPart1(sample))
	}

	@Test
	fun day8_part1_input() {
		val answer = Day08.runPart1(input)
		println("Answer for day 8 part 1 is $answer")
	}
}
