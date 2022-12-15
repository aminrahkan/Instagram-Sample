package ir.aminrahkan.instagramsample.data.db.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/12/22 - 2022
// Project name : Instagram Sample

@Entity(tableName = "posts_table")
@Parcelize
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
    var isLiked: Boolean,
    @ColumnInfo(name = "like_count")
    val likeCount: Int,
    @ColumnInfo(name = "comment_count")
    val commentCount: Int,
    @ColumnInfo(name = "caption")
    val caption: String
) : Parcelable