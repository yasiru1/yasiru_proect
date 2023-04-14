package com.yasiru.inntavola.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.yasiru.inntavola.data.remote.ItemRemoteDataSource
import com.yasiru.inntavola.data.remote.ItemService
import com.yasiru.inntavola.data.remote.NullOnEmptyConverterFactory
import com.yasiru.inntavola.data.repository.ItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // https://www.thecocktaildb.com/api.php use free api
    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("http://scanworld.lk")
        .addConverterFactory(NullOnEmptyConverterFactory())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideCharacterService(retrofit: Retrofit): ItemService = retrofit.create(ItemService::class.java)

    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(characterService: ItemService) = ItemRemoteDataSource(characterService)

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: ItemRemoteDataSource
    ) =
        ItemRepository(remoteDataSource)
}
