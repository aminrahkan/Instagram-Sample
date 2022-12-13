package ir.aminrahkan.instagramsample.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.aminrahkan.instagramsample.app.constant.PagingConstant
import ir.aminrahkan.instagramsample.data.db.dao.PostDao
import ir.aminrahkan.instagramsample.data.db.entities.Post
import kotlinx.coroutines.delay


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/12/22 - 2022
// Project name : Instagram Sample


class PostPagingSource(private val postDao: PostDao) : PagingSource<Int, Post>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        val page = params.key ?: PagingConstant.DEFAULT_PAGE_INDEX

        return try {
            val entities = postDao.getAllPost(params.loadSize, page * params.loadSize)

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

    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }


}