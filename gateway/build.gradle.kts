
plugins {
    kotlin("jvm") version "1.4.10"
    id("java-library")
}

dependencies {
    implementation(project(":common"))

    val sdkVersion: String by project.parent!!.extra
    implementation("com.inductiveautomation.ignitionsdk", "ignition-common", sdkVersion)
    implementation("com.inductiveautomation.ignitionsdk", "gateway-api", sdkVersion)
}
