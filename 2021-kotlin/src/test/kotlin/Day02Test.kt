import kotlin.test.Test
import kotlin.test.assertEquals

class Day02Test {
	private val part1SampleInput by resource("day02_part01_sample.txt")
	private val part1Input by resource("day02_part01_input.txt")

	@Test
	fun day2_part1_sample() {
		assertEquals(150, Day02.runPart1(part1SampleInput))
	}

	@Test
	fun day2_part1_input() {
		val answer = Day02.runPart1(part1Input)
		println("Answer for day 2 part 1 is $answer")
	}

	private val part2SampleInput = part1SampleInput
	private val part2Input = part1Input

	@Test
	fun day2_part2_sample() {
		assertEquals(900, Day02.runPart2(part2SampleInput))
	}

	@Test
	fun day2_part2_input() {
		val answer = Day02.runPart2(part2Input)
		println("Answer for day 2 part 2 is $answer")
	}
}
