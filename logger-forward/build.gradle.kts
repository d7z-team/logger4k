import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    `maven-publish`
    id("org.jlleitschuh.gradle.ktlint")
    id("org.jlleitschuh.gradle.ktlint-idea")
}
java {
    modularity.inferModulePath.set(true)
}

ktlint {
    version.set("0.42.1")
}

tasks.withType<Zip> {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE // allow duplicates
}

java.sourceCompatibility = JavaVersion.VERSION_11

val compileKotlin: KotlinCompile by tasks
val compileJava: JavaCompile by tasks
compileJava.destinationDirectory.set(compileKotlin.destinationDirectory.get())

dependencies {
    compileOnly("org.slf4j:slf4j-api:2.0.0-alpha5")
    implementation(project(":logger-core"))
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib"))
    testImplementation("org.slf4j:slf4j-api:2.0.0-alpha5")
    testImplementation("org.slf4j:slf4j-simple:2.0.0-alpha5")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.junit.platform:junit-platform-launcher:1.8.2")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "11"
}

publishing {
    publications {
        register<MavenPublication>("gpr") {
            groupId = rootProject.group.toString()
            artifactId = project.name
            version = rootProject.version.toString()
            from(components["java"])
        }
    }
    repositories {
        mavenLocal()
    }
}
