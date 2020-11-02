# Kotlin Module

### About

Kotlin is a relatively new, relatively modern language that, at minimum, offers a lot of syntactic 'sugar' over plain Java.
This repo is a mostly-useless 'proof of concept' of building an entire Ignition module using Kotlin, rather than Java.

### Orientation

This project uses Gradle as the build system. Gradle is configured using `build.gradle` (or `build.gradle.kts`, more on that later) files.
In the project root, there is also a `settings.gradle.kts` file that tells Gradle about the 'subprojects' (directories containing their own `build.gradle` files) in this project.
In this simple example, there are only three projects - a `common` project, and the `designer` and `gateway` projects, which depend on `common`, allowing code to be re-used without duplicated effort.
Each subproject, meanwhile, contains some actual code.

#### Common
* `extension.kt`
Contains 'extension methods' used throughout. Kotlin de-sugars these into static methods that accept a class instance as the first argument - the end result being a method that actually appears on the class, but isn't actually part of it.

* `FastExcelWrapper.kt`
Contains the actual implementation of a simple function to expose an external library ([`fastexcel`](https://github.com/dhatim/fastexcel)) via Ignition's scripting interface.

* `build.gradle.kts`
A Gradle build/config file, written in the Kotlin Gradle DSL (hence the .kts extension) - _coincidentally_ to this project being written in Kotlin, Gradle also exposes two configuration languages: Groovy and Kotlin.
Groovy is a more dynamic, Python-like language, but lacks the safety of static typing. 
The Kotlin buildscript DSL, meanwhile, is more verbose, and can be harder to find documentation for.
There's no strict idiomatic approach or strong reason to choose one or the other, and the buildscript language is independent of the project's language.
The only Ignition-specific feature here is the `modlApi` dependency declaration (provided by the `io.ia.sdk.modl` plugin) - this tells Ignition to provide the `fastexcel-reader` .jar to all the scopes our code will run in.

#### Gateway
* `KotlinExampleGatewayHook`
Contains the implementation of the 'Gateway Hook' - the base level API entrypoint for an Ignition module that will do _something_ in the Gateway scope. Most sub-systems are accessed through the `GatewayContext` provided in `setup()`.

#### Designer
* `KotlinExampleDesignerHook`
The counterpoint to the Gateway hook - the designer-scoped entrypoint to your module. Does the same thing as the gateway hook - registers a scripting function with the local script manager, but through a slightly different initialization hook.