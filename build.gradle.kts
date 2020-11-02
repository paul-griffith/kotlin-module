plugins {
    id("io.ia.sdk.modl") version ("0.0.1-SNAPSHOT")
}

version = "0.0.1-SNAPSHOT"

extra["sdkVersion"] = "8.1.0-SNAPSHOT"

ignitionModule {
    name.set("Kotlin Example")
    fileName.set("Kotlin-Example.modl")
    id.set("com.griffithindustries.kotlin.KotlinExample")
    moduleVersion.set("$version")
    moduleDescription.set("A simple example of writing an Ignition module in Kotlin")
    requiredIgnitionVersion.set("8.1.0")
    projectScopes.set(mapOf(
        ":common" to "GD",
        ":designer" to "D",
        ":gateway" to "G"
    ))
    moduleDependencies.set(mapOf())
    hooks.set(mapOf(
        "com.griffithindustries.kotlin.gateway.KotlinExampleGatewayHook" to "G",
        "com.griffithindustries.kotlin.designer.KotlinExampleDesignerHook" to "D"
    ))
}

tasks.getByName("signModule").enabled = false
