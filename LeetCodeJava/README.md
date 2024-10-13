# About The Project

This is the project to slove LeetCode solution in Java. leverage Gradle - a powerful build automation tool primarily used for multi-language software development and growing popularity in morden Java project.

Gradle were use to automate the build, format and test of our current project. Moreover, with Java programming language power, Gradle allow we to run our Java project at ease.

This is single Java application in Gradle. For sturcture reference ([Here](https://docs.gradle.org/current/userguide/part1_gradle_init.html#part1_begin)).

```text
.
├── .gradle
│   ├── libs.version.toml (1)
│   └── ⋮
├── gradle
│   └── **wrapper** (2)
├── gradlew (macOS and Linux script for executing builds using the Gradle Wrapper)
├── gradlew.bat (Windows script for executing builds using the Gradle Wrapper)
├── settings.gradle.kts (3)
├── app
│   ├── build.gradle.kts (4)
│   └── src (5)
└── ⋮
```

💡 **Noitce:** All command run from our **root directory** ( . directory)

1. The version catalog which defines a set of versions for dependencies in a central location.
2. Contains the JAR file and configuration of the Gradle Wrapper.
3. The project’s settings file where the list of subprojects is defined.
4. Build script file - **Most of configuration of our single app project configured here**.
5. The source code and build configuration for the Java app.

# Getting Started

## Prerequisites

- Gradle install locally. If not you can use `./gradlew` or `./gradlew.bat` (Gradle wrapper depend on your OS) script which is auto update gradle and install dependency.
- Java version 17+ (Go with any version you linke)
- Spotless with java-google-format for formatting.
- sonarlint for linting (this is optional and you can configure this as a VSCode extension if you like)

## Installation

Clone the project, cd into LeetCodeJava then run the following to init gradle & install dependency:

```bash
./gradlew (Linux)
./gradlew.bat (Windows)
```

## Usage & Explain

### Run the main class and test

---

Basically, you run the solution function through test.
Main package is configure in build script (build.gradle.kts):

```kotlin
application {
    // Define the main class for the application (Use Gradle application plugin + Feel free to change this).
    mainClass = "com.fluorurine.App"
}
```

Main class located `src/main/java/(mainClasspackage)/App.java` - you can define any project package here in this `java` dir and project import will work.
=> test dir files can be define within the same package and can import other package if needed.

Define new solution in their group of Java class.
This project use JUNIT4 for testing. Test file in the test folder which I define as the same package as the the main Class for easy import problem group.
JUnit4 Naming Covention: surfix or prefix Test and use @Test with suitable assert method. Finally, to test those method:

```bash
./gradlew test
```

Fun fact: The test task in build.gradle.kts have been modify for verbose (with AI suggestion) - you can google for this to displaying html report too.

- Personally, I use offical Java Red Hat Extension and Gradle on Vscode for quick edit.

### Linting

This project use Google Java format (latest version) with spotless as describe in kts file: (Format before testing :^) )

```kotlin
  googleJavaFormat().aosp().reflowLongStrings().skipJavadocFormatting()
```

for formatting run:

```bash

./gradlew spotlessApply

```

[here is document link](https://github.com/diffplug/spotless/blob/main/plugin-gradle/README.md)
