package ir.aminrahkan.instagramsample.app.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.aminrahkan.instagramsample.data.local.db.AppDatabase
import ir.aminrahkan.instagramsample.data.repository.CommentRepository
import ir.aminrahkan.instagramsample.data.repository.PostRepository
import javax.inject.Singleton


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/12/22 - 2022
// Project name : Instagram Sample

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providePostRepository(appDatabase: AppDatabase): PostRepository {
        return PostRepository(appDatabase.postDao())
    }

    @Provides
    @Singleton
    fun provideCommentRepository(appDatabase: AppDatabase): CommentRepository {
        return CommentRepository(appDatabase.commentDao())
    }
}