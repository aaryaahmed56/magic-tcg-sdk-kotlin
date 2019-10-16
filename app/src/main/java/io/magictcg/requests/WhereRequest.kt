package io.magictcg.requests

abstract class WhereRequest<T>(
    params: Map<String, Any?>
) : Request<T> {

    protected val query: Map<String, Any?> = params.filterValues { it != null }
}