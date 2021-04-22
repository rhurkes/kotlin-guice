import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.4.32"
}

application {
    mainClass.set("com.example.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.inject:guice:5.0.1")
    implementation("dev.misfitlabs.kotlinguice4:kotlin-guice:1.4.1")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
        kotlinOptions.allWarningsAsErrors = false
    }
}
