package ir.aminrahkan.instagramsample.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/12/22 - 2022
// Project name : Instagram Sample

@Entity(tableName = "posts_data")
data class Post(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val postId: Int,
    @ColumnInfo(name = "user_avatar")
    val userAvatar: String,
    @ColumnInfo(name = "user_name")
    val userName: String,
    @ColumnInfo(name = "image_address")
    val imageAddress: String,
    @ColumnInfo(name = "is_liked")
    val isLiked: Boolean,
    @ColumnInfo(name = "like_count")
    val likeCount: Int,
    @ColumnInfo(name = "comment_count")
    val commentCount: Int,
    @ColumnInfo(name = "caption")
    val caption: String
)