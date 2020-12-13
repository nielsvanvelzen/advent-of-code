import kotlin.test.Test

class Day13Test {
	val SAMPLE_INPUT = """
		939
		7,13,x,x,59,x,31,19
	""".trimIndent()

	val REAL_INPUT = """
		1002462
		37,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,601,x,x,x,x,x,x,x,x,x,x,x,19,x,x,x,x,17,x,x,x,x,x,23,x,x,x,x,x,29,x,443,x,x,x,x,x,x,x,x,x,x,x,x,13
	""".trimIndent()

	@Test
	fun `d13_p1_sample`() {
		Day13.run(SAMPLE_INPUT)
	}

	@Test
	fun `d13_p1_input`() {
		Day13.run(REAL_INPUT)
	}
}
