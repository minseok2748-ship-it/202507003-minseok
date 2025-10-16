
plugins {
    kotlin("jvm") version "2.0.0"
    application
}

repositories { mavenCentral() }

application { mainClass.set("store.MainKt") }

tasks.jar {
    manifest { attributes["Main-Class"] = "store.MainKt" }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
