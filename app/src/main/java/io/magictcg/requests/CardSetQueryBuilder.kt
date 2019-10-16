package io.magictcg.requests

class CardSetQueryBuilder(
    var name: String? = null,
    var type: String? = null,
    var block: String? = null,
    var pageSize: Int? = null
) : QueryBuilder {

    override fun toParams(): Map<String, Any?> = mapOf(
        "name" to name,
        "type" to type,
        "block" to block,
        "pageSize" to pageSize
    )
}