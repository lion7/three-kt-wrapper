plugins {
    kotlin("js")
    `maven-publish`
}

kotlin {
    js(IR) {
        browser()
        binaries.library()
    }
}

dependencies {
    implementation(npm("three", "0.137.5", false))
}
