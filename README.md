# magic-tcg-sdk-kotlin
Unofficial alternative Kotlin wrapper for the [Magic: The Gathering - Developers API](https://magicthegathering.io/).

## Usage

### Cards, Sets

```kotlin
val mtg = Mtg()

// Obtain all possible cards and sets.
val cards = mtg.card().all()

val sets = mtg.set().all()
```
Along with [RxJava3](https://github.com/ReactiveX/RxJava) and querying support, with relevant query fields in [CardQueryBuilder.kt](https://github.com/asefahmed56/magic-tcg-sdk-kotlin/blob/master/app/src/main/java/io/magictcg/requests/CardQueryBuilder.kt) and [CardSetQueryBuilder.kt](https://github.com/asefahmed56/magic-tcg-sdk-kotlin/blob/master/app/src/main/java/io/magictcg/requests/CardSetQueryBuilder.kt).

#### RxJava3

```kotlin
val mtg = Mtg()

// RxJava3 Card Subscription
mtg.card().observeAll()
	.subscribe({ cards ->
		// ...
	}, { t -> 
		// Some error...
	})
  
// RxJava3 Set Subscription
mtg.set().observeAll()
	.subscribe({ sets ->
		// ...
	}, { t -> 
		// Some error...
	})
```

#### Queries

```kotlin
val mtg = Mtg()

// Card Queries
val cards = mtg.card()
        .where {
            rarity = "Mythic Rare"
            
            // Alternatively "Instant|Sorcery|Artifact"
            types = "Instant" or "Sorcery" or "Artifact" 
            ...
        }
        .all() // or .observeAll() for RxJava3
        
val sets = mtg.set()
        .where {
            name = "Khans of Tarkir"
            type = "expansion"
            ...
        }
        .all() // or .observeAll() for RxJava3
```

### Types

```kotlin
val mtg = Mtg()

// Obtain all possible types, subtypes, and supertypes.

// Types: Artifact, Conspiracy, Creature...
val types = mtg.types().all()

// SubTypes: Advisor, Anjani, Alara... 
val subtypes = mtg.subTypes().all()

// SuperTypes: Basic, Legendary, Ongoing...
val supertypes = mtg.superTypes().all()
```
