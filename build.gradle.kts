import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
    application
}

group = "me.jeff"
version = "1.0-SNAPSHOT"

sourceSets.create("integrationTest") {
    resources.srcDir("src/resources")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation (group= "org.apache.commons", name= "commons-csv", version = "1.5")
    implementation ("com.google.firebase:firebase-admin:7.3.0")
    implementation (group= "com.github.dpaukov", name= "combinatoricslib3", version = "3.3.0")
    compile ("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation(kotlin("test-junit"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
}