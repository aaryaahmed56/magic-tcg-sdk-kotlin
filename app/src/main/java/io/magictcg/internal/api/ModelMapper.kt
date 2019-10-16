package io.magictcg.internal.api

import io.magictcg.model.*

internal object ModelMapper {
    fun to(model: CardModel): Card {
        return Card(
            model.id,
            model.name,
            model.names,
            model.manaCost,
            model.cmc,
            model.colors,
            model.colorIdentity,
            model.supertypes?.map { SuperType.find(it) },
            model.types?.map { Type.find(it) },
            model.subtypes?.map { SubType.find(it) },
            model.rarity,
            model.set,
            model.setName,
            model.text,
            model.artist,
            model.number,
            model.power,
            model.toughness,
            model.loyalty,
            model.multiverseid,
            model.imageUrl,
            model.layout,
            model.legalities?.map { to(it) },
            model.rulings?.map { to(it) },
            model.foreignNames?.map { to(it) }
        )
    }


    private fun to(model: LegalityModel): Legality {
        return Legality(model.format, model.legality)
    }


    private fun to(model: ForeignNameModel): ForeignName {
        return ForeignName(
            model.name,
            model.imageUrl,
            model.language,
            model.multiverseid
        )
    }


    private fun to(model: RulingModel): Ruling {
        return Ruling(model.text)
    }


    fun to(model: CardSetModel): CardSet {
        return CardSet(
            model.code,
            model.name,
            model.type,
            model.block
        )
    }
}