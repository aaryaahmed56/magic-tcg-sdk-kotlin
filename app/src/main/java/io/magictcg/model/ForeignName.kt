package io.magictcg.model

data class ForeignName(
    val name: String,
    val imageUrl: String,
    val language: String,
    val multiverseid: Int?
)