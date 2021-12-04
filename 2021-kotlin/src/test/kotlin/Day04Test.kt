import kotlin.test.Test
import kotlin.test.assertEquals

class Day04Test {
	private val part1SampleInput by resource("day04_part01_sample.txt")
	private val part1Input by resource("day04_part01_input.txt")

	@Test
	fun day4_part1_sample() {
		assertEquals(4512, Day04.runPart1(part1SampleInput))
	}

	@Test
	fun day4_part1_input() {
		val answer = Day04.runPart1(part1Input)
		println("Answer for day 4 part 1 is $answer")
	}

	private val part2SampleInput = part1SampleInput
	private val part2Input = part1Input

	@Test
	fun day4_part2_sample() {
		assertEquals(1924, Day04.runPart2(part1SampleInput))
	}

	@Test
	fun day4_part2_input() {
		val answer = Day04.runPart2(part1Input)
		println("Answer for day 4 part 2 is $answer")
	}
}
