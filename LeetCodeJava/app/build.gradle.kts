/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.10.2/userguide/building_java_projects.html in the Gradle documentation.
 * This project uses @Incubating APIs which are subject to change.
 */
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    
    id("com.diffplug.spotless") version "7.0.0.BETA2"

}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // This dependency is used by the application.
    implementation(libs.guava)
}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use JUnit4 test framework
            useJUnit("4.13.2")
        }
    }
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

application {
    // Define the main class for the application.
    mainClass = "com.fluorurine.App"
}

spotless {
    // Optional: limit format enforcement to just the files changed by this feature branch
    ratchetFrom("origin/main")

    format("misc") {
        // Define the files to apply `misc` to
        target("*.gradle", ".gitattributes", ".gitignore")

        // Define the steps to apply to those files
        trimTrailingWhitespace()
        indentWithTabs() // or spaces. Takes an integer argument if you don't like 4
        endWithNewline()
    }

    java {
        // Don't need to set target, it is inferred from Java

        // Apply a specific flavor of google-java-format
        googleJavaFormat().aosp().reflowLongStrings().skipJavadocFormatting()

        // Fix formatting of type annotations
        formatAnnotations()

        // Make sure every file has the following copyright header.
        // Optionally, Spotless can set copyright years by digging
        // through git history (see "license" section below)
        licenseHeader("/* (C)2024 */")
    }
}

tasks.test {
    // Configure test logging
    testLogging {
        // Log events for passed, failed, and skipped tests
        events("passed", "failed", "skipped")

        // Show the stack trace for failed tests
        exceptionFormat = TestExceptionFormat.FULL

        // Optionally, you can log standard output and error
        showStandardStreams = true
    }
}