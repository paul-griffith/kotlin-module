# Kotlin Module

### About

Kotlin is a relatively new, relatively modern language that, at minimum, offers a lot of syntactic 'sugar' over plain Java.
This repo is a mostly-useless 'proof of concept' of building an entire Ignition module using Kotlin, rather than Java.

### Orientation

This project uses Gradle as the build system. Gradle is configured using `build.gradle` (or `build.gradle.kts`, more on that later) files.
In the project root, there is also a `settings.gradle.kts` file that tells Gradle about the 'subprojects' (directories containing their own `build.gradle` files) in this project.
In this simple example, there are only three projects - a `common` project, and the `designer` and `gateway` projects, which depend on `common`, allowing code to be re-used without duplicated effort.
