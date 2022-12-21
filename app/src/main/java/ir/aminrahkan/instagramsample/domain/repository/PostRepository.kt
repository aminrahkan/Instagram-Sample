package ir.aminrahkan.instagramsample.domain.repository

import androidx.paging.PagingData
import ir.aminrahkan.instagramsample.data.local.db.entities.Post
import kotlinx.coroutines.flow.Flow


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/21/22 - 2022
// Project name : Instagram Sample


interface PostRepository {

    fun getPostsFromDb(): Flow<PagingData<Post>>
    suspend fun updatePostLikeValue(post: Post)
}