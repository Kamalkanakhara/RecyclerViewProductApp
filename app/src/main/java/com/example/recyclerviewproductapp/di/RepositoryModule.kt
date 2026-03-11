package com.example.recyclerviewproductapp.di

import com.example.recyclerviewproductapp.ProductApi
import com.example.recyclerviewproductapp.data.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(
        api: ProductApi
    ): ProductRepository {

        return ProductRepository(api)
    }
}