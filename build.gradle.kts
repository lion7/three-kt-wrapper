plugins {
    kotlin("js") version "1.6.10" apply false
    id("org.ajoberstar.grgit") version "4.1.0"
}

tasks {
    wrapper {
        gradleVersion = "7.3"
    }
}

allprojects {
    group = "info.laht"
    version = grgit.describe()

    repositories {
        mavenCentral()
    }
}
