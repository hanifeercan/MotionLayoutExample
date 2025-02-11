package com.hercan.motionlayoutexample.core.data.repo

import com.hercan.motionlayoutexample.core.common.ResponseState
import com.hercan.motionlayoutexample.core.data.model.Cartoon
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getCartoons(): Flow<ResponseState<List<Cartoon>>>
}