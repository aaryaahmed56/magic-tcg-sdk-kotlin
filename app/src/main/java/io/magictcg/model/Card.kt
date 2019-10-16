package io.magictcg.model

data class Card(
    val id: String?,
    val name: String,
    val names: List<String>?,
    val manaCost: String,
    val cmc: Int?,
    val colors: List<String>?,
    val colorIdentity: List<String>?,
    val supertypes: List<SuperType>?,
    val types: List<Type>?,
    val subtypes: List<SubType>?,
    val rarity: String,
    val set: String,
    val setName: String,
    val text: String?,
    val artist: String,
    val number: String?,
    val power: String?,
    val toughness: String?,
    val loyalty: String?,
    val multiverseid: Int?,
    val imageUrl: String,
    val layout: String,
    val legalities: List<Legality>?,
    val rulings: List<Ruling>?,
    val foreignNames: List<ForeignName>?
)