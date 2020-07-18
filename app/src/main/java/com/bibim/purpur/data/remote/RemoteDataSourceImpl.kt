package com.bibim.purpur.data.remote

import com.bibim.purpur.data.remote.retrofit.NetworkServiceImpl


class RemoteDataSourceImpl : RemoteDataSource {
    val api = NetworkServiceImpl.SERVICE

}