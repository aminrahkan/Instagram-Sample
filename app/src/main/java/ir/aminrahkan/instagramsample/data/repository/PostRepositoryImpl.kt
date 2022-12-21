package ir.aminrahkan.instagramsample.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import ir.aminrahkan.instagramsample.app.constant.PagingConstant
import ir.aminrahkan.instagramsample.data.datasource.PostPagingSource
import ir.aminrahkan.instagramsample.data.local.db.dao.PostDao
import ir.aminrahkan.instagramsample.data.local.db.entities.Post
import ir.aminrahkan.instagramsample.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/12/22 - 2022
// Project name : Instagram Sample


class PostRepositoryImpl(private val postDao: PostDao) : PostRepository {

    override fun getPostsFromDb(): Flow<PagingData<Post>> {

        return Pager(
            PagingConfig(pageSize = PagingConstant.DEFAULT_PAGE_SIZE, enablePlaceholders = true)
        ) {
            PostPagingSource(postDao)
        }.flow
    }

    override suspend fun updatePostLikeValue(post: Post) {
        postDao.updatePost(post)
    }
}