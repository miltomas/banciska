plugins {
    java
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
	implementation("com.google.code.gson:gson:2.7")
	implementation("com.thoughtworks.xstream:xstream:1.4.21")
	implementation("com.google.inject:guice:7.0.0")
}

application {
    mainClass.set("org.example.Main")
}

tasks.test {
    useJUnitPlatform()
}
