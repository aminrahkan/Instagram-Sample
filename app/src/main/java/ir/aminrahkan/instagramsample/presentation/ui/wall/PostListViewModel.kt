package ir.aminrahkan.instagramsample.presentation.ui.wall

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import ir.aminrahkan.instagramsample.data.model.PostModel
import ir.aminrahkan.instagramsample.data.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/12/22 - 2022
// Project name : Instagram Sample


class PostListViewModel() : ViewModel() {

    @Inject
    lateinit var postRepository: PostRepository

    fun getPostsFromDb(): Flow<PagingData<PostModel>> {
        return postRepository.getPostsFromDb()
    }

    /*fun getPostsFromApi(): Flow<PagingData<PostModel>>{
        return
    }*/

}