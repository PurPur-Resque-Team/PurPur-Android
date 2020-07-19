package com.bibim.purpur.data.remote.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class CookiesInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request =
            chain.request().newBuilder()
                .header("jwt", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZHgiOjE2LCJpYXQiOjE1OTUxMzkwMTcsImV4cCI6MTYwMjkxNTAxN30.gWLElC5C8eUG4JFOKv0d37ef6illMKMIECPjWCYtOAU")

//        if (PURPUR.USER_TOKEN != "") {
//            request.addHeader("jwt", PURPUR.USER_TOKEN)
//        }

        return chain.proceed(request.build())
    }
}
