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
include(":app")
include(":core")
include(":feature:auth")
include(":feature:services")
include(":feature:petpassport")
include(":feature:chat")
include(":feature:profile")
include(":feature:Appointments")
include(":feature:appointments")
include(":core:mvi")
