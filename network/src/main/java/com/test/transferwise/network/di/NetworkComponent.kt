package com.test.transferwise.network.di

import com.squareup.moshi.Moshi
import com.test.transferwise.network.BuildConfig
import com.test.transferwise.network.api.characters.CharactersApi
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {

    val charactersApi: CharactersApi

    @Component.Factory
    interface Factory {
        fun create(): NetworkComponent
    }
}

@Module
private object NetworkModule {

    @Provides
    @Singleton
    fun okHttpClientBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .apply {
                if (BuildConfig.DEBUG) {
                    addNetworkInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                }
            }
    }

    @Provides
    @Singleton
    fun retrofitBuilder(moshi: Moshi): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
    }

    @Provides
    @Singleton
    fun moshi(): Moshi {
        return Moshi.Builder().build()
    }

    @Provides
    @Singleton
    fun charactersApi(retrofitBuilder: Retrofit.Builder): CharactersApi {
        return retrofitBuilder.build().create(CharactersApi::class.java)
    }
}
