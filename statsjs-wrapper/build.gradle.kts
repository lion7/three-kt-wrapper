plugins {
    kotlin("js")
}

kotlin {
    js(IR) {
        browser()
        binaries.library()
    }
}

dependencies {
    implementation(npm("stats.js", "0.17.0", false))
}
