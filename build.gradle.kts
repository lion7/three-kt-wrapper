plugins {
    kotlin("js") version "1.6.10" apply false
}

tasks {
    wrapper {
        gradleVersion = "7.3"
    }
}

subprojects {
    repositories {
        mavenCentral()
    }
}
