
plugins {
    id("io.ia.sdk.modl") version ("0.0.1-SNAPSHOT")
}

extra["sdkVersion"] = "8.1.0-SNAPSHOT"

version = "0.0.1-SNAPSHOT"

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

//ignitionModule {
//    /*
//     * Human readable name of the module, as will be displayed on the gateway status page
//     */
//    name = "Kotlin Example"
//
//    /*
//     * Name of the '.modl' file to be created, without file extension.
//     */
//    fileName = "Kotlin-Example.modl"
//    /*
//     * Unique identifier for the module.  Reverse domain convention is recommended (e.g.: com.mycompany.charting-module)
//     */
//    id = "com.griffithindustries.kotlin.KotlinExample"
//
//    moduleVersion = version
//
//    moduleDescription = "A short sentence describing what it does, but not much longer than this."
//    /*
//     * Minimum version of Ignition required for the module to function correctly.  This typically won't change over
//     * the course of a major Ignition (7.9, 8.0, etc) version, except for when the Ignition Platform adds/changes APIs
//     * used by the module.
//     */
//    requiredIgnitionVersion = "8.0.10"
//    /*
//     *  This is a map of String: String, where the 'key' represents the fully qualified path to the project
//     *  (using gradle path syntax), and the value is the shorthand Scope string.
//     *  Example entry: [ ":gateway": "G", ":common": "GC", ":vision-client": "C" ]
//     */
//    projectScopes = [
//        ":common" : "GD",
//        ":designer" : "D",
//        ":gateway" : "G"
//    ]
//
//    /*
//     * Add your module dependencies here, following the examples, with scope being one or more of G, C or D,
//     * for (G)ateway, (D)esigner, Vision (C)lient.
//     *
//     * Example Value:
//     * moduleDependencies = [
//           "com.inductiveautomation.vision": "CD",
//           "com.inductiveautomation.opcua": "G"
//     * ]
//     */
//    moduleDependencies = [ : ]
//
//    /*
//     * Map of fully qualified hook class to the shorthand scope.  Only one scope per hook class.
//     *
//     * Example entry: "com.myorganization.vectorizer.VectorizerDesignerHook": "D"
//     */
//    hooks = [
//        "com.griffithindustries.kotlin.gateway.KotlinExampleGatewayHook" : "G",
//        "com.griffithindustries.kotlin.designer.KotlinExampleDesignerHook" : "D"
//    ]
//
//    /**
//     * Path to the property file that contains key/value pairs which define the locations of and credentials for
//     * module signing.  Optional if passing values as runtime flags, project props, or using the gradle.properties file
//     * to store the required key:value pairs.
//     *
//     * In a property file, the following keys are required, shown with example values:
//     * ```
//     * ignition.signing.keystoreFile=/path/to/keystorefile.jks
//     * ignition.signing.keystorePassword=somepassword
//     * ignition.signing.certFile=/path/to/certfile.pem
//     * ignition.signing.certPassword=somepassword
//     * ignition.signing.alias=selfsigned
//     * ```
//     *
//     * To use runtime values, or to override values in the property file, call the sign task with input flags, or mix
//     * and match as desired. Flag names are the same as the final element in the property file keys.  E.g. -
//     * `ignition.signing.keystoreFile` becomes the runtime task flag of `keystoreFile`.
//     *```
//     * ./gradlew signModule --keystoreFile=/path/to/keystore --keystorePassword=somepassword --alias=myAlias
//     *```
//     *
//     */
//     // Default convention value is applied automatically using value shown below.  Uncomment to set/override.
//     propertyFile = project.file("${System.getProperty("user.home")}/signing.properties")
//}
