# magic-tcg-sdk-kotlin
Unofficial alternative Kotlin wrapper for the [Magic: The Gathering - Developers API](https://magicthegathering.io/) implementing the structure of the one for Pokemon, i.e. [pokemon-tcg-sdk-kotlin](https://github.com/PokemonTCG/pokemon-tcg-sdk-kotlin).
## Usage

### Cards, Sets

```kotlin
// Instantiate the Mtg Class.
val mtg = Mtg()

// Obtain all possible cards and sets.
val mtg.card().all()

val mtg.set().all()
```
Along with [RxJava3](https://github.com/ReactiveX/RxJava) and Query Support, with relevant query fields in [CardQueryBuilder.kt](https://github.com/asefahmed56/magic-tcg-sdk-kotlin/blob/master/app/src/main/java/io/magictcg/requests/CardQueryBuilder.kt) and [CardSetQueryBuilder.kt](https://github.com/asefahmed56/magic-tcg-sdk-kotlin/blob/master/app/src/main/java/io/magictcg/requests/CardSetQueryBuilder.kt).

### Types

```kotlin
// Instantiate the Mtg Class.
val mtg = Mtg()

// Obtain all possible types, subtypes, and supertypes.

// Types: Artifact, Conspiracy, Creature...
val types = mtg.types().all()

// SubTypes: Advisor, Anjani, Alara... 
val subtypes = mtg.subTypes().all()

// SuperTypes: Basic, Legendary, Ongoing...
val supertypes = mgt.superTypes().all()
```
