object Day06 {
	fun runPart1(input: String): Int {
		val fish = input.split(",").map(String::toInt).toMutableList()

		repeat(80) {
			for (index in fish.indices) {
				when (fish[index]) {
					0 -> {
						fish[index] = 6
						fish.add(8)
					}
					else -> fish[index]--
				}
			}
		}

		return fish.size
	}
}
