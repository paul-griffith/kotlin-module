plugins {
    kotlin("jvm")
    id("java-library")
}

dependencies {
    implementation(project(":common"))

    val sdkVersion: String by project.parent!!.extra
    implementation("com.inductiveautomation.ignitionsdk", "designer-api", sdkVersion)
    implementation("com.inductiveautomation.ignitionsdk", "ignition-common", sdkVersion)

    modlApi(kotlin("stdlib"))
}
