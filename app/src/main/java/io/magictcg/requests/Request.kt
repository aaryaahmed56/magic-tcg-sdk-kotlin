package io.magictcg.requests

import io.reactivex.rxjava3.core.Observable

interface Request<T> {

    fun all(): List<T>
    fun observeAll(): Observable<List<T>>
}