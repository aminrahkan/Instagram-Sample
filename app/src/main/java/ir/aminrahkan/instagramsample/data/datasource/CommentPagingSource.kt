package ir.aminrahkan.instagramsample.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.aminrahkan.instagramsample.app.constant.PagingConstant
import ir.aminrahkan.instagramsample.data.db.dao.CommentDao
import ir.aminrahkan.instagramsample.data.db.dao.PostDao
import ir.aminrahkan.instagramsample.data.db.entities.Comment
import ir.aminrahkan.instagramsample.data.db.entities.Post
import kotlinx.coroutines.delay


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/12/22 - 2022
// Project name : Instagram Sample


class CommentPagingSource(private val commentDao: CommentDao, private val postId: Int) :
    PagingSource<Int, Comment>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Comment> {
        val page = params.key ?: PagingConstant.DEFAULT_PAGE_INDEX

        return try {
            val entities = commentDao.getCommentsByPostId(
                params.loadSize,
                page * params.loadSize,
                postId = postId
            )

            // simulate page loading
            if (page != 0) delay(1500)

            LoadResult.Page(
                data = entities,
                prevKey = if (page == PagingConstant.DEFAULT_PAGE_INDEX) null else page - 1,
                nextKey = if (entities.isEmpty()) null else page + 1
            )

        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Comment>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }


}