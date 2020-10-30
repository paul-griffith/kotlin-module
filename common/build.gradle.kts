plugins {
    kotlin("jvm") version "1.4.10"
    id("java-library")
}

dependencies {
    val sdkVersion: String by project.parent!!.extra
    implementation("com.inductiveautomation.ignitionsdk", "ignition-common", sdkVersion)

    modlApi(kotlin("stdlib"))
    modlApi(kotlin("stdlib-jdk8"))
    modlApi(kotlin("stdlib-jdk7"))
    modlApi(kotlin("stdlib-common"))
}
