package io.magictcg.internal.api

internal class CardResponse(val cards: List<CardModel>)

internal class SetResponse(val sets: List<CardSetModel>)

internal class TypeResponse(val types: List<String>)

internal class SuperTypeResponse(val supertypes: List<String>)

internal class SubTypeResponse(val subtypes: List<String>)


internal class CardModel(
    val id: String?,
    val name: String,
    val names: List<String>?,
    val manaCost: String,
    val cmc: Int?,
    val colors: List<String>?,
    val colorIdentity: List<String>?,
    val supertypes: List<String>?,
    val types: List<String>?,
    val subtypes: List<String>?,
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
    val legalities: List<LegalityModel>?,
    val foreignNames: List<ForeignNameModel>?,
    val rulings: List<RulingModel>?
)


internal class CardSetModel(
    val code: String,
    val name: String,
    val type: String,
    val block: String
)


internal class LegalityModel(
    val format: String,
    val legality: String
)


internal class ForeignNameModel(
    val name: String,
    val imageUrl: String,
    val language: String,
    val multiverseid: Int?
)


internal class RulingModel(
    val text: String
)