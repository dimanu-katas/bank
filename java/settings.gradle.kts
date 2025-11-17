rootProject.name = "bank-kata"

include(":solution")

pluginManagement {
    val spotless_version: String by settings
    plugins {
        id("com.diffplug.spotless") version spotless_version
    }
}