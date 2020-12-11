object Day04 {
	fun run(input: String, strict: Boolean = false) {
		// Parse passport input
		val passports = input.split("\\n{2}".toRegex()).map { passport ->
			passport.split("\\s+".toRegex()).map { field ->
				field.split(':', limit = 2).let { parts ->
					parts[0] to parts[1]
				}
			}.toMap()
		}

		val requiredFields = setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"/*, "cid"*/)
		var validPassports = 0
		var invalidPassports = 0
		for (passport in passports) {
			var valid = true

			// Default check
			if (!passport.keys.containsAll(requiredFields)) valid = false

			// Strict checks
			if (valid && strict) {
				val byr = passport["byr"]!!.toIntOrNull()
				if (byr == null || byr < 1920 || byr > 2002) valid = false

				val iyr = passport["iyr"]!!.toIntOrNull()
				if (iyr == null || iyr < 2010 || iyr > 2020) valid = false

				val eyr = passport["eyr"]!!.toIntOrNull()
				if (eyr == null || eyr < 2020 || eyr > 2030) valid = false

				val hgt = passport["hgt"]!!.let {
					if (it.isNotBlank()) {
						val parts = "(\\d+)(in|cm)".toRegex().matchEntire(it)?.groupValues
						if (parts == null) null
						else parts[1].toInt() to parts[2]
					} else null
				}

				if (hgt == null) valid = false
				else if (hgt.second == "cm" && (hgt.first < 150 || hgt.first > 193)) valid = false
				else if (hgt.second == "in" && (hgt.first < 59 || hgt.first > 76)) valid = false

				val hcl = passport["hcl"]!!
				if (!hcl.matches("#[0-9a-f]{6}".toRegex())) valid = false

				val ecl = passport["ecl"]!!
				if (ecl !in setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")) valid = false

				val pid = passport["pid"]!!
				if (!pid.matches("\\d{9}".toRegex())) valid = false
			}

			// Save
			if (valid) validPassports++
			else invalidPassports++
		}

		println("From the ${passports.size} passports found: $validPassports are valid, $invalidPassports are invalid")
	}
}
