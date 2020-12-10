object Day10 {
	fun run(input: String) {
		val adapters = input.lines().map(String::toInt).sorted()

		var currentJoly = 0
		val usedAdapters = mutableListOf<Int>()
		val jump1 = mutableListOf<Int>()
		val jump3 = mutableListOf<Int>(0)

		for (adapter in adapters) {
			if (currentJoly.rangeTo(currentJoly + 3).contains(adapter)) {
				val diff = adapter - currentJoly

				usedAdapters += adapter
				currentJoly = adapter

				if (diff == 1) jump1 += adapter
				else if (diff == 3) jump3 += adapter
			} else {
				println("stopping jump too big")
				break
			}
		}

		println("jump1 ${jump1.size} * jump3 ${jump3.size} = ${jump1.size * jump3.size}")
	}
}
