package ir.aminrahkan.instagramsample.presentation.ui.wall

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.aminrahkan.instagramsample.data.db.entities.Post
import ir.aminrahkan.instagramsample.data.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/12/22 - 2022
// Project name : Instagram Sample

@HiltViewModel
class PostListViewModel @Inject constructor(private var postRepository: PostRepository) :
    ViewModel() {


    fun getPostsFromDb(): Flow<PagingData<Post>> {
        return postRepository.getPostsFromDb().cachedIn(viewModelScope)
    }


}