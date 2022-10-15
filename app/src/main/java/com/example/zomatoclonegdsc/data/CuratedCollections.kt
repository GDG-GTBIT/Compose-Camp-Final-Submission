package com.example.zomatoclonegdsc.data

enum class CuratedCollections(
    val title: String,
    val noOfPlaces: Int,
) {
    ROMANTIC(
        title = "Romantic Dining",
        noOfPlaces = 15
    ),
    BUFFETS(
        title = "Great Buffets",
        noOfPlaces = 11
    ),
    CLUBS(
        title = "Buzzing Nightlife & Clubs",
        noOfPlaces = 8
    ),
    INSTA(
        title = "Insta Worthy Places",
        noOfPlaces = 9
    ),
    LUXURY(
        title = "Luxury at its Best",
        noOfPlaces = 17
    ),
    COCKTAILS(
        title = "Exotic Cocktails",
        noOfPlaces = 13
    )
}

fun getAllCuratedCollections(): List<CuratedCollections> {
    return listOf(
        CuratedCollections.ROMANTIC,
        CuratedCollections.BUFFETS,
        CuratedCollections.CLUBS,
        CuratedCollections.INSTA,
        CuratedCollections.LUXURY,
        CuratedCollections.COCKTAILS
    )
}
