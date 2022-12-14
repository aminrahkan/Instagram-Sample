package ir.aminrahkan.instagramsample.presentation.ui.wall.adapter

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
import ir.aminrahkan.instagramsample.data.db.entities.Post

// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/12/22 - 2022
// Project name : Instagram Sample


class PostListAdapter(private val onClickListener: OnClickListener) :
    PagingDataAdapter<Post, RecyclerView.ViewHolder>(DiffComparator) {

    companion object {
        private val DiffComparator = object : DiffUtil.ItemCallback<Post>() {

            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean =
                oldItem == newItem

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post = getItem(position)
        holder.itemView.setOnClickListener {

            if (post != null) {
                onClickListener.onClick(post)
            }
        }
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

        private var imgPost: ImageView = view.findViewById(R.id.ivPost)
        private var imgAvatar: ImageView = view.findViewById(R.id.ivAvatar)
        private var txtLikedBy: TextView = view.findViewById(R.id.tv_liked_by)
        private var txtCommentCount: TextView = view.findViewById(R.id.tv_comment_count)
        private var txtCaption: TextView = view.findViewById(R.id.tv_caption)
        private var txtUserName: TextView = view.findViewById(R.id.tv_user_name)
        private var imgLike: ImageView = view.findViewById(R.id.ivLike)

        fun bindView(item: Post?) {
            imgPost.layoutParams.height = getSuitableSizeForImage(itemView.context)


            imgPost.load(item?.imageAddress) { placeholder(R.drawable.placeholder) }


            imgAvatar.load(item?.userAvatar)

            val likedByStringBuilder = StringBuilder()
            likedByStringBuilder.append(itemView.context.getString(R.string.likedy_by)).append(" ")
                .append(item?.likeCount.toString()).append(" ").append(
                    itemView.context.getString(
                        R.string.people
                    )
                )
            txtLikedBy.text = likedByStringBuilder.toString()

            txtUserName.text = item?.userName
            txtCaption.text = item?.caption

            val commentCountStringBuilder =
                StringBuilder().append(item?.commentCount.toString()).append(" ")
                    .append(itemView.context.getString(R.string.comments))
            txtCommentCount.text = commentCountStringBuilder.toString()

            if (item?.isLiked == true) imgLike.setImageResource(R.drawable.ic_like) else imgLike.setImageResource(
                R.drawable.ic_no_like
            )
        }

    }

    class OnClickListener(val clickListener: (post: Post) -> Unit) {
        fun onClick(post: Post) = clickListener(post)
    }

}


