plugins {
    kotlin("js")
}

kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }
}

dependencies {
    implementation(project(":threejs-wrapper"))
    implementation(project(":statsjs-wrapper"))
}
