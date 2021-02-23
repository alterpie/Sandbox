# Sandbox project to try out the newest libraries

## App description

Application uses public [API](https://rickandmortyapi.com/) and allows you to dive into the world of **Rick and Morty** cartoon. 
Currently you can check on existing characters and see detailed description for every character.

## Technologies used

* MVI architecture
* [Kotlin coroutines](https://github.com/Kotlin/kotlinx.coroutines) for multithreading
* [Coil](https://github.com/coil-kt/coil) for image loading
* [Dagger2](https://github.com/google/dagger) for dependency injection
* [Retrofit2](https://github.com/square/retrofit) for network communication
* [Moshi](https://github.com/square/moshi) for json de/serialisation
* [Room](https://developer.android.com/jetpack/androidx/releases/room) for local persistence
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) for configuration changes 
* [Navigation](https://developer.android.com/guide/navigation) for navigation
* Gradle composite builds for module configuration

## TODO:

* ~~Migrate to gradle kotlin scripts using composite builds~~
* Add more feature screens(episodes, locations)
* Pretty UI
    * Come up with nice looking UI for screens
    * Support dark mode
* Compose UI for presentation layer
    * Try configuration changes without Activity recreation
    * Ditch Jetpack ViewModel in favor of remember { } for plain ViewModel without inheritance
    * Try to handle localisation changes with CompositionLocal
    * Implement custom theme
    * Try out Navigation Compose
* Replace Moshi with Kotlin Serialization
* Replace Retrofit2 with Ktor
* Replace Room with SQLDelight
