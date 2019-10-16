package io.magictcg.requests

interface QueryBuilder {

    fun toParams(): Map<String, Any?>
}