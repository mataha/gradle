plugins {
    java
}

version = "1.0.2"
group = "org.gradle.sample"

repositories {
    mavenCentral()
}

testing {
    suites {
        val unitTest by getting {
            useJUnitPlatform()

            dependencies {
                implementation("org.junit.jupiter:junit-jupiter:5.7.1")
            }
        }

        val integrationTest by registering {
            dependencies {
                implementation(project)
            }

            targets {
                all {
                    testTask.configure {
                        shouldRunAfter(unitTest)
                    }
                }
            }
        }
    }
}

tasks.named("check") {
    dependsOn(testing.suites.named("integrationTest"))
}
