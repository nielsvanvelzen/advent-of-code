import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {
	private val part1SampleInput by resource("day01_part01_sample.txt")
	private val part1Input by resource("day01_part01_input.txt")

	@Test
	fun day1_part1_sample() {
		assertEquals(7, Day01.runPart1(part1SampleInput))
	}

	@Test
	fun day1_part1_input() {
		val answer = Day01.runPart1(part1Input)
		println("Answer for day 1 part 1 is $answer")
	}

	private val part2SampleInput = part1SampleInput
	private val part2Input = part1Input

	@Test
	fun day1_part2_sample() {
		assertEquals(5, Day01.runPart2(part2SampleInput))
	}

	@Test
	fun day1_part2_input() {
		val answer = Day01.runPart2(part2Input)
		println("Answer for day 1 part 2 is $answer")
	}
}
