package ir.aminrahkan.instagramsample.presentation.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.aminrahkan.instagramsample.data.local.db.entities.Comment
import ir.aminrahkan.instagramsample.data.local.db.entities.Post
import ir.aminrahkan.instagramsample.data.repository.CommentRepositoryImpl
import ir.aminrahkan.instagramsample.data.repository.PostRepositoryImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/12/22 - 2022
// Project name : Instagram Sample

@HiltViewModel
class DetailModelView @Inject constructor(private var commentRepository: CommentRepositoryImpl, private var postRepository: PostRepositoryImpl) :
    ViewModel() {


    fun getCommentsFromDb(postId:Int): Flow<PagingData<Comment>> {
        return commentRepository.getCommentFromDb(postId).cachedIn(viewModelScope)
    }

    suspend fun insertComment(comment:Comment){
        commentRepository.insertComment(comment)
    }
    suspend fun updatePostLikeValue(post: Post){
        postRepository.updatePostLikeValue(post)
    }

}