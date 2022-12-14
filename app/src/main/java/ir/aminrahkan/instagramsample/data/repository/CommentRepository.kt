package ir.aminrahkan.instagramsample.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import ir.aminrahkan.instagramsample.app.constant.PagingConstant
import ir.aminrahkan.instagramsample.data.datasource.CommentPagingSource
import ir.aminrahkan.instagramsample.data.db.dao.CommentDao
import ir.aminrahkan.instagramsample.data.db.entities.Comment
import kotlinx.coroutines.flow.Flow


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/12/22 - 2022
// Project name : Instagram Sample


class CommentRepository(private val commentDao: CommentDao) {

    fun getCommentFromDb(pagingConfig: PagingConfig = getDefaultPageConfig()): Flow<PagingData<Comment>> {

        return Pager(
            pagingConfig
        ) {
            CommentPagingSource(commentDao)
        }.flow
    }

    suspend fun insertComment(comment: Comment) {
        commentDao.insertComment(comment)
    }

    private fun getDefaultPageConfig(): PagingConfig {
        return PagingConfig(pageSize = PagingConstant.DEFAULT_PAGE_SIZE, enablePlaceholders = true)
    }
}