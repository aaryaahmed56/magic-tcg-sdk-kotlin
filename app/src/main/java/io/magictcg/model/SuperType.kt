package io.magictcg.model

enum class SuperType(internal var text: String? = null) {
    BASIC("Basic"),
    LEGENDARY("Legendary"),
    ONGOING("Ongoing"),
    SNOW("Snow"),
    WORLD("World"),
    UNKNOWN;

    val displayName: String
        get() = text ?: name.toLowerCase().capitalize()


    companion object {
        private val VALUES by lazy { values() }

        fun find(text: String): SuperType {
            val supertypes = VALUES.find { it.text.equals(text, true) } ?: UNKNOWN
            if (supertypes == UNKNOWN) {
                supertypes.text = text
            }
            return supertypes
        }
    }
}