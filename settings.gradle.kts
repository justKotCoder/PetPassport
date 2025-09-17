pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PetPassportNew"

include(":app", ":core", ":core:mvi", ":data")
include(":feature:auth", ":feature:services", ":feature:petpassport",
    ":feature:chat", ":feature:profile", ":feature:appointments", ":feature:settings")

// (новые data-модули — при желании)
include(":data:firebase-analytics", ":data:firebase-firestore", ":data:firebase-messaging")
