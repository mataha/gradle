plugins {
    `kotlin-dsl`
}

description = "Provides a plugin to define the version and name for subproject publications"

group = "gradlebuild"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
        vendor = JvmVendorSpec.ADOPTIUM
    }
}

dependencies {
    api(platform(projects.buildPlatform))

    implementation(projects.basics)

    implementation("com.google.code.gson:gson")
}
