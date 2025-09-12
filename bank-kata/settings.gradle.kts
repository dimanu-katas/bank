rootProject.name = "bank-kata"

pluginManagement {
    val spotless_version: String by settings
    plugins {
        id("com.diffplug.spotless") version spotless_version
    }
}