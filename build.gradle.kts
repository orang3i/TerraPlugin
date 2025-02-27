plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    flatDir {
        dirs("libs") // Tell Gradle to search in "libs" for JARs
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    compileOnly(files("C:\\Users\\orang\\IdeaProjects\\Lumen\\build\\libs\\LumenServer.jar"))
    implementation("de.articdive:jnoise-pipeline:4.1.0")


}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveBaseName.set("SimpleWorldGenerator")
    archiveClassifier.set("")
    archiveVersion.set("")
    mergeServiceFiles() // Ensures service loader files are merged correctly
}