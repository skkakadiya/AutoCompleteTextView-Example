package com.test.autocompletetextviewexample

import retrofit2.Response

class UserRepository(
    private val apiService: APIService
) {

    suspend fun searchUser(name: String): Response<MainResponse> {
        return apiService.searchUser(name)
    }
}
