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

tasks {
    register<Jar>("sourcesJar") {
        from(kotlin.sourceSets.main.get().kotlin)
        archiveClassifier.set("sources")
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["kotlin"])
            artifact(tasks["sourcesJar"])
        }
    }
}
