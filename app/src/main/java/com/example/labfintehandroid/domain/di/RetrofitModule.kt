package com.example.labfintehandroid.domain.di

import androidx.core.os.BuildCompat
import com.example.labfintehandroid.domain.retrofit.Constant.BASE_URL
import com.example.labfintehandroid.domain.retrofit.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideHttp() : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor())
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(client : OkHttpClient) : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(client)
        .build()

    @Provides
    @Singleton
    fun provideMovieApi(retrofit : Retrofit) : MovieApi = retrofit.create(MovieApi::class.java)

    class ApiKeyInterceptor() : Interceptor {
        override fun intercept(chain : Interceptor.Chain) : Response {
            val curRequest = chain.request()
            val newRequest = curRequest.newBuilder()
                .addHeader("x-api-key", "e30ffed0-76ab-4dd6-b41f-4c9da2b2735b")
                .build()
            return chain.proceed(newRequest)
        }

    }
}