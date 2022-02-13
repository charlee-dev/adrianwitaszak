package com.adwi.site.model

data class Education(
    val schoolName: String,
    val date: String,
    val link: String,
    val specialization: String
)

val educations = listOf(
    Education(
        schoolName = "Android Kotlin Developer - Bootcamp",
        date = "03/2020 - 07/2020",
        link = "https://www.udacity.com/course/android-kotlin-developer-nanodegree--nd940",
        specialization = ""
    ),
    Education(
        schoolName = "Education Abroad - Wyzsza Szkola Komunikacji i Zarzadzania",
        date = "09/2005 - 06/2008",
        link = "https://www.wskiz.edu/en/",
        specialization = "Computer Science"
    )
)
