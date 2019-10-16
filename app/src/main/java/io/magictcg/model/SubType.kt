package io.magictcg.model

enum class SubType(internal var text: String? = null) {
    ADVISOR("Advisor"),
    ANJANI("Anjani"),
    ALARA("Alara"),
    ALLY("Ally"),
    ANGEL("Angel"),
    ANTELOPE("Antelope"),
    APE("Ape"),
    ARCANE("Arcane"),
    UNKNOWN;

    val displayName: String
        get() = text ?: name.toLowerCase().capitalize()


    companion object {
        private val VALUES by lazy { values() }

        fun find(text: String): SubType {
            val subtypes = VALUES.find { it.text.equals(text, true) } ?: UNKNOWN
            if (subtypes == UNKNOWN) {
                subtypes.text = text
            }
            return subtypes
        }
    }
}