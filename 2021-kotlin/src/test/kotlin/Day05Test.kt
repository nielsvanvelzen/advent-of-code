import kotlin.test.Test
import kotlin.test.assertEquals

class Day05Test {
	private val part1SampleInput by resource("day05_part01_sample.txt")
	private val part1Input by resource("day05_part01_input.txt")

	@Test
	fun day5_part1_sample() {
		assertEquals(5, Day05.runPart1(part1SampleInput))
	}

	@Test
	fun day5_part1_input() {
		val answer = Day05.runPart1(part1Input)
		println("Answer for day 5 part 1 is $answer")
	}
}
