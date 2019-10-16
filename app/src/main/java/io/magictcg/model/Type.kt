package io.magictcg.model

enum class Type(internal var text: String? = null) {
    ARTIFACT("Artifact"),
    CONSPIRACY("Conspiracy"),
    CREATURE("Creature"),
    ENCHANTMENT("Enchantment"),
    INSTANT("Instant"),
    LAND("Land"),
    PHENOMENON("Phenomenon"),
    PLANE("Plane"),
    PLANESWALKER("Planeswalker"),
    SCHEME("Scheme"),
    SORCERY("Sorcery"),
    TRIBAL("Tribal"),
    VANGUARD("Vanguard"),
    UNKNOWN;

    val displayName: String
        get() = text ?: name.toLowerCase().capitalize()


    companion object {
        val VALUES by lazy { values() }

        fun find(text: String): Type {
            val type = VALUES.find { it.name.equals(text, true) } ?: UNKNOWN
            if (type == UNKNOWN) {
                type.text = text
            }
            return type
        }
    }
}