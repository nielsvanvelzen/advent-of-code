import kotlin.test.Test
import kotlin.test.assertEquals

class Day03Test {
	private val part1SampleInput by resource("day03_part01_sample.txt")
	private val part1Input by resource("day03_part01_input.txt")

	@Test
	fun day3_part1_sample() {
		assertEquals(198, Day03.runPart1(part1SampleInput))
	}

	@Test
	fun day3_part1_input() {
		val answer = Day03.runPart1(part1Input)
		println("Answer for day 3 part 1 is $answer")
	}
}
