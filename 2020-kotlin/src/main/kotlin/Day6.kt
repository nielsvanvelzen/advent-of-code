object Day6 {
	fun run(input: String) {
		// Convert to List<List<List<Char>>> (group<person<answer>>>)
		val groups = input.split("\\n{2}".toRegex()).map { group ->
			group.lines().map(String::toCharArray).map(CharArray::toList)
		}

		// Calculate
		val anyAnswered = groups.map { group -> group.reduce { acc, person -> acc.union(person).toList() }.size }.sum()
		val allAnswered = groups.map { group -> group.reduce { acc, person -> acc.intersect(person).toList() }.size }.sum()

		// Output
		println("anyAnswered $anyAnswered, allAnswered $allAnswered")
	}
}
