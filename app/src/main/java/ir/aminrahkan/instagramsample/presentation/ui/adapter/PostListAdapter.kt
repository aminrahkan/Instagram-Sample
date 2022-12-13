package ir.aminrahkan.instagramsample.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ir.aminrahkan.instagramsample.R
import ir.aminrahkan.instagramsample.data.model.PostModel


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/12/22 - 2022
// Project name : Instagram Sample


class PostListAdapter : PagingDataAdapter<PostModel, RecyclerView.ViewHolder>(DiffComparator) {

    companion object {
        private val DiffComparator = object : DiffUtil.ItemCallback<PostModel>() {

            override fun areItemsTheSame(oldItem: PostModel, newItem: PostModel): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: PostModel, newItem: PostModel): Boolean =
                oldItem == newItem

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? PostViewHolder)?.bindView(item = getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PostViewHolder.getInstance(parent)
    }

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        companion object {
            fun getInstance(parent: ViewGroup): PostViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.item_post, parent, false)
                return PostViewHolder(view)
            }
        }

        fun bindView(item: PostModel?) {

        }
    }
}


