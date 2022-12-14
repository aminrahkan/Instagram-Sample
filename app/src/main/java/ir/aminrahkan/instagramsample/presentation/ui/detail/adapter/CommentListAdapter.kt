package ir.aminrahkan.instagramsample.presentation.ui.detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ir.aminrahkan.instagramsample.R
import ir.aminrahkan.instagramsample.app.utils.getSuitableSizeForImage
import ir.aminrahkan.instagramsample.data.db.entities.Comment
import ir.aminrahkan.instagramsample.data.db.entities.Post

// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/12/22 - 2022
// Project name : Instagram Sample


class CommentListAdapter() :
    PagingDataAdapter<Comment, RecyclerView.ViewHolder>(DiffComparator) {

    companion object {
        private val DiffComparator = object : DiffUtil.ItemCallback<Comment>() {

            override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean =
                oldItem == newItem

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? CommentViewHolder)?.bindView(comment = getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CommentViewHolder.getInstance(parent)
    }

    class CommentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        companion object {
            fun getInstance(parent: ViewGroup): CommentViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.item_comment, parent, false)
                return CommentViewHolder(view)
            }
        }

        private var txtComment: TextView = view.findViewById(R.id.tv_comment)

        fun bindView(comment: Comment?) {
            txtComment.text = comment?.comment
        }


    }


}


