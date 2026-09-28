plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-fabric")
}

dependencies {
    modApi(sharedLibs.fabricapi.fabric)
    modApi(sharedLibs.puzzleslib.fabric)
}

tasks.named("generateModJson") {
    doLast {
        val file = file("build/generated/resources/fabric.mod.json")
        if (file.exists()) {
            val text = file.readText().replace("\"minecraft\": \"~26.4-\"", "\"minecraft\": [\">=26.4-snapshot-1\", \">=26.4-alpha.1\"]")
            file.writeText(text)
        }
    }
}

project(":Common") {
    tasks.matching { it.name == "compileJava" || it.name == "createMinecraftArtifacts" }.configureEach {
        enabled = false
    }
}

