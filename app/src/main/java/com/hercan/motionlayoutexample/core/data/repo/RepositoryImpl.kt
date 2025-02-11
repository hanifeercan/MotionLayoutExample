package com.hercan.motionlayoutexample.core.data.repo

import com.hercan.motionlayoutexample.core.common.ResponseState
import com.hercan.motionlayoutexample.core.data.model.Cartoon
import com.hercan.motionlayoutexample.core.network.source.RestDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val restDataSource: RestDataSource) : Repository {
    override suspend fun getCartoons(): Flow<ResponseState<List<Cartoon>>> {
        return flow {
            emit(ResponseState.Loading)
            val response = restDataSource.getCartoons()
            emit(ResponseState.Success(response.mapTo { it.toCartoonList() }))
        }.catch {
            emit(ResponseState.Error(it.message.orEmpty()))
        }
    }
}