pluginManagement {
    repositories {
        gradlePluginPortal()
        maven {
            name = "Architectury"
            url = uri("https://maven.architectury.dev/")
        }
        maven {
            name = "Fabric"
            url = uri("https://maven.fabricmc.net/")
        }
        maven {
            name = "NeoForge"
            url = uri("https://maven.neoforged.net/releases/")
        }
        exclusiveContent {
            forRepository {
                maven {
                    name = "Fuzs Mod Resources"
                    url = uri("https://raw.githubusercontent.com/Fuzss/modresources/main/maven/")
                }
            }
            filter {
                @Suppress("UnstableApiUsage")
                includeGroupAndSubgroups("fuzs.multiloader")
            }
        }
    }
}

plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-settings") version providers.gradleProperty("project.plugins")
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
    }
    versionCatalogs {
        named("sharedLibs") {
            version("minecraft", "26.4")
            version("game", "26.4-snapshot-1")
            version("fabricapi-version", "0.161.1+26.4")
            version("fabricloader-version", "0.19.5")
            version("cloth", "26.3.9999")
        }
    }
}
