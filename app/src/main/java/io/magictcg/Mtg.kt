package io.magictcg

import io.magictcg.internal.api.ModelMapper
import io.magictcg.internal.api.RxApiService
import io.magictcg.internal.api.SyncApiService
import io.magictcg.model.*
import io.magictcg.requests.*
import io.magictcg.util.result
import io.reactivex.rxjava3.core.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Root API object for interfacing with the io.magictcg.com API
 */
class Mtg {

    companion object {
        const val DEFAULT_API_URL = "https://api.magicthegathering.io/v1/"
    }

    private val okHttpClient: OkHttpClient
    private val syncService: SyncApiService
    private val rxService: RxApiService


    constructor() : this(Config())
    constructor(config: Config) {

        val logging = HttpLoggingInterceptor()
        logging.level = config.logLevel
        okHttpClient = if (config.client != null) {
            config.client
        } else {
            OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
        }

        val retroFit = Retrofit.Builder()
            .baseUrl(config.apiUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        syncService = retroFit.create(SyncApiService::class.java)
        rxService = retroFit.create(RxApiService::class.java)
    }

    fun card(): QueryRequest<Card, CardQueryBuilder> = CardBuilder()
    fun set(): QueryRequest<CardSet, CardSetQueryBuilder> = SetBuilder()
    fun types(): Request<Type> = TypesBuilder()
    fun superTypes(): Request<SuperType> = SuperTypesBuilder()
    fun subTypes(): Request<SubType> = SubTypesBuilder()


    /**
     * Helper class to build a query
     */
    private inner class CardBuilder : QueryRequest<Card, CardQueryBuilder> {

        override fun where(query: CardQueryBuilder): WhereRequest<Card> {
            return Where(query.toParams())
        }


        override fun where(query: CardQueryBuilder.() -> Unit): WhereRequest<Card> {
            val queryBuilder = CardQueryBuilder()
            queryBuilder.query()
            return Where(queryBuilder.toParams())
        }


        inner class Where(params: Map<String, Any?>) : WhereRequest<Card>(params) {

            override fun all(): List<Card> {
                return syncService.getCards(query)
                    .result()
                    .cards
                    .map { ModelMapper.to(it) }
            }


            override fun observeAll(): Observable<List<Card>> {
                return rxService.getCards(query)
                    .map { it.cards }
                    .map { it.map { ModelMapper.to(it) } }
            }
        }


        override fun all(): List<Card> {
            return syncService.getCards()
                .result()
                .cards
                .map { ModelMapper.to(it) }
        }


        override fun observeAll(): Observable<List<Card>> {
            return rxService.getCards()
                .map { it.cards }
                .map { it.map { ModelMapper.to(it) } }
        }


        override fun find(id: String): Card {
            return ModelMapper.to(syncService.getCard(id).result())
        }


        override fun observeFind(id: String): Observable<Card> {
            return rxService.getCard(id)
                .map { ModelMapper.to(it) }
        }
    }


    /**
     * Helper class to assemble Set queries
     */
    private inner class SetBuilder : QueryRequest<CardSet, CardSetQueryBuilder> {

        override fun where(query: CardSetQueryBuilder): WhereRequest<CardSet> {
            return Where(query.toParams())
        }


        override fun where(query: CardSetQueryBuilder.() -> Unit): WhereRequest<CardSet> {
            val queryBuilder = CardSetQueryBuilder()
            queryBuilder.query()
            return Where(queryBuilder.toParams())
        }


        inner class Where(params: Map<String, Any?>): WhereRequest<CardSet>(params) {

            override fun all(): List<CardSet> {
                return syncService.getSets(query)
                    .result()
                    .sets
                    .map { ModelMapper.to(it) }
            }


            override fun observeAll(): Observable<List<CardSet>> {
                return rxService.getSets(query)
                    .map { it.sets }
                    .map { it.map { ModelMapper.to(it) } }
            }
        }


        override fun all(): List<CardSet> {
            return syncService.getSets()
                .result()
                .sets
                .map { ModelMapper.to(it) }
        }


        override fun observeAll(): Observable<List<CardSet>> {
            return rxService.getSets()
                .map { it.sets }
                .map { it.map { ModelMapper.to(it) } }
        }


        override fun find(id: String): CardSet {
            return ModelMapper.to(syncService.getSet(id).result())
        }


        override fun observeFind(id: String): Observable<CardSet> {
            return rxService.getSet(id)
                .map { ModelMapper.to(it) }
        }
    }


    private inner class TypesBuilder : Request<Type> {

        override fun all(): List<Type> {
            return syncService.getTypes()
                .result()
                .types
                .map { Type.find(it) }
        }


        override fun observeAll(): Observable<List<Type>> {
            return rxService.getTypes()
                .map { it.types }
                .map { it.map { Type.find(it) } }
        }
    }


    private inner class SuperTypesBuilder: Request<SuperType> {

        override fun all(): List<SuperType> {
            return syncService.getSuperTypes()
                .result()
                .supertypes
                .map { SuperType.find(it) }
        }


        override fun observeAll(): Observable<List<SuperType>> {
            return rxService.getSuperTypes()
                .map { it.supertypes }
                .map { it.map { SuperType.find(it) } }
        }
    }


    private inner class SubTypesBuilder: Request<SubType> {

        override fun all(): List<SubType> {
            return syncService.getSubTypes()
                .result()
                .subtypes
                .map { SubType.find(it) }
        }


        override fun observeAll(): Observable<List<SubType>> {
            return rxService.getSubTypes()
                .map { it.subtypes }
                .map { it.map { SubType.find(it) } }
        }
    }
}