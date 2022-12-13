package ir.aminrahkan.instagramsample.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.aminrahkan.instagramsample.app.constant.PagingConstant
import ir.aminrahkan.instagramsample.data.model.PostModel
import java.io.IOException


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/12/22 - 2022
// Project name : Instagram Sample


class PostPagingSource():PagingSource<Int,PostModel>() {



    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PostModel> {
        val page = params.key ?: PagingConstant.DEFAULT_PAGE_INDEX

        return try {

            val response = doggoApiService.getDoggoImages(page, params.loadSize)

            LoadResult.Page(
                response, prevKey = if (page == PagingConstant.DEFAULT_PAGE_INDEX) null else page - 1,
                nextKey = if (response.isEmpty()) null else page + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PostModel>): Int? {

    }


}