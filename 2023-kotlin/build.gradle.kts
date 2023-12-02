buildscript {
	repositories {
		mavenCentral()
	}

	dependencies {
		classpath(libs.kotlin.gradle)
	}
}

plugins {
	alias(libs.plugins.kotlin.jvm)
}

group = "nl.ndat"
version = "1.0-SNAPSHOT"

dependencies {
	testImplementation(libs.kotlin.test.junit)
}
