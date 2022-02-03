# Catch'em all!


The project's aim is to develop a nativa Kotlin Android app that shows a Pokemon list and a pokemon detail with its image, abilities and stats

## Table of Contents
- [Project description](#project-description)
- [Behavioral requirements](#behavioral-requirements)
- [Technical requirements](#technical-requirements)
- [Tools](#tools)
- [Contributor](#contributor)


## Project description 
The project is a native Kotlin Android app, Clean Architecture based, with a minimum SDK level 23.
The source of data is referred to the following [APIs address](https://pokeapi.co).

## Behavioral requirements
When a user taps on a PokÈmon, the app will show a detailed view of PokÈmonís name, images, stats, and category (fire, smoke, etc).

## Technical requirements
- __Kotlin__ with Coroutines 
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous
- Min SDK level 23
- __Clean Architecture__ (Repository Pattern)
- MVI pattern ([Uniflow](https://github.com/uniflow-kt/uniflow-kt))
- Dependency injection with __Hilt__
- Retrofit2 & OkHttp3 (construct the REST APIs and paging network data)
- __Moshi__
- Glide, GlidePalette

## Tools
- Android Studio
- IntelliJ Idea Ultimate
- GitHub Actions with CI

## Contributor
<a href="https://github.com/LucreziaC">
 <img alt="LucreziaC" width="90" height="90" src="https://avatars.githubusercontent.com/u/37901017?v=4" />
</a>
