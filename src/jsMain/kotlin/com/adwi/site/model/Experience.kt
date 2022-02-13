package com.adwi.site.model

data class Experience(
    val title: String,
    val date: String,
    val description: String,
    val stack: List<String>,
    val features: List<String>,
    val image: String,
    val url: String,
)

val experiences = listOf(
    Experience(
        title = "Pex Wallpapers",
        date = "08/2020 - 02/2021",
        description = "Automatic Wallpapers App in Jetpack Compose. ",
        stack = listOf(
            "Kotlin",
            "Jetpack Compose",
            "Coroutines",
            "Retrofit",
            "Room",
            "Jetpack ViewModel",
            "Paging 3",
            "WorkManager",
            "Hilt"
        ),
        features = listOf(
            "Modern architecture",
            "Modularity - feature layered",
            "Single activity",
            "MVVM design pattern"
        ),
        image = "images/wallpapers.png",
        url = "https://github.com/adrianwitaszak/PexWallpapers"
    ),
    Experience(
        title = "Pex Walls XML",
        date = "04/2020 - 09/2020",
        description = "Automatic Wallpapers app in Xml",
        stack = listOf(
            "Kotlin",
            "Coroutines",
            "Retrofit",
            "Room",
            "Jetpack ViewModel",
            "Paging 3",
            "WorkManager",
            "Hilt"
        ),
        features = listOf(
            "Single activity with Fragments",
            "View system",
            "Jetpack Navigation",
            "MVVM design pattern"
        ),
        image = "images/walls.png",
        url = "https://github.com/adrianwitaszak/PexWallpapersXml"
    ),
    Experience(
        title = "Shoppe - Client app",
        date = "06/2021 - Present",
        description = "Shopping app - Android, Desktop(Windows, MacOs, Linux)",
        stack = listOf(
            "Kotlin",
            "Coroutines",
            "Serialization",
            "Jetbrains Jetpack Compose",
            "Ktor",
            "Apollo",
            "SqlDelight",
            "ArkIvanov's Decompose",
            "Kodein"
        ),
        features = listOf(
            "Kotlin Multiplatform",
            "Modern architecture",
            "Modularity - feature layered",
            "MVI design pattern",
            "No ViewModel - MVI handles state",
            "Shared business logic",
            "Shared UI",
        ),
        image = "images/shoppe.png",
        url = "https://github.com/adrianwitaszak/shoppe"
    ),
    Experience(
        title = "Shoppe - Backend",
        date = "04/2021 - 06/2021",
        description = "Backend for Shoppe app",
        stack = listOf(
            "Kotlin",
            "Ktor",
            "Coroutines",
            "GraphQL",
            "MongoDB",
            "Apollo",
            "Kodein"
        ),
        features = listOf(
            "Kotlin Ktor server",
            "Layered architecture",
            "Heroku CI",
            "MVVM pattern",
        ),
        image = "images/shoppe-backend.png",
        url = "https://github.com/adrianwitaszak/shoppe-backend"
    ),
    Experience(
        title = "Betty",
        date = "02/2021 - 03/2021",
        description = "Odds Checking App",
        stack = listOf(
            "Kotlin",
            "Jetpack Compose",
            "Coroutines",
            "Retrofit",
            "Room",
            "Jetpack ViewModel",
            "Hilt"
        ),
        features = listOf(
            "Single activity",
            "MVVM design pattern"
        ),
        image = "images/betty.png",
        url = "https://github.com/adrianwitaszak/Betty"
    ),
    Experience(
        title = "AW - Portfolio",
        date = "01/2022 - Present",
        description = "This portfolio, this resume and contact page",
        stack = listOf(
            "Kotlin",
            "Compose for Web",
            "Kobweb",
        ),
        features = listOf(
            "Latest tech from Jetbrains",
            "Deployed on Netlify and Github Pages",
            "Responsive design",
            "http://adrianw.co.uk"
        ),
        image = "images/portfolio.png",
        url = "https://github.com/adrianwitaszak/adrianwitaszak"
    ),
)