package com.bibim.purpur.data.remote.retrofit

import com.bibim.purpur.`object`.PURPUR
import okhttp3.Interceptor
import okhttp3.Response

class CookiesInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request =
            chain.request().newBuilder()
                .header("jwt", PURPUR.USER_TOKEN)

//        if (PURPUR.USER_TOKEN != "") {
//            request.addHeader("jwt", PURPUR.USER_TOKEN)
//        }

        return chain.proceed(request.build())
    }
}
