package ir.aminrahkan.instagramsample.app.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.aminrahkan.instagramsample.app.constant.DbConstant
import ir.aminrahkan.instagramsample.data.db.AppDatabase
import ir.aminrahkan.instagramsample.data.db.dao.PostDao
import javax.inject.Singleton


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/13/22 - 2022
// Project name : Instagram Sample


@Module
@InstallIn(SingletonComponent::class)
class DbModule {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DbConstant.DATA_BASE_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun providePostDao(): PostDao {
        return PostDao()
    }

}