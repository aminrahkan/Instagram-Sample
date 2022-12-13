package ir.aminrahkan.instagramsample.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import ir.aminrahkan.instagramsample.app.constant.PagingConstant
import ir.aminrahkan.instagramsample.data.datasource.PostPagingSource
import ir.aminrahkan.instagramsample.data.model.PostModel
import kotlinx.coroutines.flow.Flow


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/12/22 - 2022
// Project name : Instagram Sample


class PostRepository() {


    fun getPostsFromDb(pagingConfig: PagingConfig = getDefaultPageConfig()): Flow<PagingData<PostModel>> {

        //TODO Database Handle
        //if (appDatabase == null) throw IllegalStateException("Database is not initialized")

        val pagingSourceFactory = {
            //appDatabase.getDoggoImageModelDao().getAllDoggoModel()
        }
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = pagingSourceFactory,
            remoteMediator = DoggoMediator(doggoApiService, appDatabase)
        ).flow
    }

    /*
    fun getPostFromApi(pagingConfig: PagingConfig = getDefaultPageConfig()): Flow<PagingData<PostModel>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { PostPagingSource(doggoApiService) }
        ).flow
    }
    */


    private fun getDefaultPageConfig(): PagingConfig {
        return PagingConfig(pageSize = PagingConstant.DEFAULT_PAGE_SIZE, enablePlaceholders = true)
    }
}