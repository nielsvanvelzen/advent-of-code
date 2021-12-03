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

	private val part2SampleInput = part1SampleInput
	private val part2Input = part1Input

	@Test
	fun day3_part2_sample() {
		assertEquals(230, Day03.runPart2(part1SampleInput))
	}

	@Test
	fun day3_part2_input() {
		val answer = Day03.runPart2(part1Input)
		println("Answer for day 3 part 2 is $answer")
	}
}
