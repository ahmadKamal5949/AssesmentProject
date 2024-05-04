pluginManagement {
    repositories {
        google()
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

rootProject.name = "Assesment"
include(":app")
include(":Listing:data")
include(":Listing:domain")
include(":Listing:presentation")
include(":Details:data")
include(":Details:domain")
include(":Details:presentation")
include(":common:utils")
