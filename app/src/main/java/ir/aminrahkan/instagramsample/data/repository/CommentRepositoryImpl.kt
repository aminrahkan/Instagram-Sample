package ir.aminrahkan.instagramsample.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import ir.aminrahkan.instagramsample.app.constant.PagingConstant
import ir.aminrahkan.instagramsample.data.datasource.CommentPagingSource
import ir.aminrahkan.instagramsample.data.local.db.dao.CommentDao
import ir.aminrahkan.instagramsample.data.local.db.entities.Comment
import ir.aminrahkan.instagramsample.domain.repository.CommentRepository
import kotlinx.coroutines.flow.Flow


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/12/22 - 2022
// Project name : Instagram Sample


class CommentRepositoryImpl(private val commentDao: CommentDao) : CommentRepository {

    override fun getCommentFromDb(
        postId: Int
    ): Flow<PagingData<Comment>> {
        return Pager(
            PagingConfig(pageSize = PagingConstant.DEFAULT_PAGE_SIZE, enablePlaceholders = true)
        ) {
            CommentPagingSource(commentDao, postId)
        }.flow
    }

    override suspend fun insertComment(comment: Comment) {
        commentDao.insertComment(comment)
    }

}