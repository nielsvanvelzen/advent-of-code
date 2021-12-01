// Gradle Plugins
buildscript {
	repositories {
		mavenCentral()
	}

	dependencies {
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
	}
}

// Dependency Repositories
dependencyResolutionManagement {
	repositories {
		mavenCentral()
	}
}
