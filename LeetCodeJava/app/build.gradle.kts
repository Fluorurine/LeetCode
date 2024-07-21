

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
      id("com.diffplug.spotless") version "6.25.0"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    implementation(libs.guava)
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    // target "src/*/java/**/*.java"


    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
   
}

application {
    // Define the main class for the application.
    mainClass = "com.truongvm.App"
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}


spotless {
  java {
    importOrder()
    removeUnusedImports()
    cleanthat()      
    googleJavaFormat()  
    formatAnnotations()
  
  }
}