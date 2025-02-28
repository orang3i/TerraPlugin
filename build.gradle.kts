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

    maven {
        url = uri("https://mvn.everbuild.org/public")
    }

    maven {
        url = uri("https://repo.codemc.io/repository/maven-public/")
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    compileOnly(files("C:\\Users\\orang\\IdeaProjects\\Lumen\\build\\libs\\LumenServer.jar"))
    implementation("de.articdive:jnoise-pipeline:4.1.0")
    implementation("com.dfsek.terra:minestom:6.6.0-BETA+810d10ac0")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveBaseName.set("TerraPlugin")
    archiveClassifier.set("")
    archiveVersion.set("")
    mergeServiceFiles() // Ensures service loader files are merged correctly
}