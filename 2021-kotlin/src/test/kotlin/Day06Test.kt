import kotlin.test.Test
import kotlin.test.assertEquals

class Day06Test {
	private val part1SampleInput by resource("day06_part01_sample.txt")
	private val part1Input by resource("day06_part01_input.txt")

	@Test
	fun day6_part1_sample() {
		assertEquals(5934, Day06.runPart1(part1SampleInput))
	}

	@Test
	fun day6_part1_input() {
		val answer = Day06.runPart1(part1Input)
		println("Answer for day 6 part 1 is $answer")
	}

	private val part2SampleInput = part1SampleInput
	private val part2Input = part1Input

	@Test
	fun day6_part2_sample() {
		assertEquals(26984457539L, Day06.runPart2(part2SampleInput))
	}

	@Test
	fun day6_part2_input() {
		val answer = Day06.runPart2(part2Input)
		println("Answer for day 6 part 2 is $answer")
	}
}
