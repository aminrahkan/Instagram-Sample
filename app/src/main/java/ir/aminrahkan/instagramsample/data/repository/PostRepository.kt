package ir.aminrahkan.instagramsample.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import ir.aminrahkan.instagramsample.app.constant.PagingConstant
import ir.aminrahkan.instagramsample.data.datasource.PostPagingSource
import ir.aminrahkan.instagramsample.data.local.db.dao.PostDao
import ir.aminrahkan.instagramsample.data.local.db.entities.Post
import kotlinx.coroutines.flow.Flow


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/12/22 - 2022
// Project name : Instagram Sample



class PostRepository(private val postDao: PostDao) {

    fun getPostsFromDb(pagingConfig: PagingConfig = getDefaultPageConfig()): Flow<PagingData<Post>> {

        return Pager(
            pagingConfig
        ) {
            PostPagingSource(postDao)
        }.flow
    }

    suspend fun updatePostLikeValue(post:Post){
        postDao.updatePost(post)
    }

    private fun getDefaultPageConfig(): PagingConfig {
        return PagingConfig(pageSize = PagingConstant.DEFAULT_PAGE_SIZE, enablePlaceholders = true)
    }
}