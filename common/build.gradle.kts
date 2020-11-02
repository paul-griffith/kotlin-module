plugins {
    kotlin("jvm")
    id("java-library")
}

dependencies {
    val sdkVersion: String by project.parent!!.extra
    implementation("com.inductiveautomation.ignitionsdk", "ignition-common", sdkVersion)

    modlApi("org.dhatim:fastexcel-reader:0.10.20")
}
