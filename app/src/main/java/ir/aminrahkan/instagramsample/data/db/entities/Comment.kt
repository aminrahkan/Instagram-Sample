package ir.aminrahkan.instagramsample.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/14/22 - 2022
// Project name : Instagram Sample

@Entity(tableName = "comment_table")
data class Comment(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val commentId: Int,
    @ColumnInfo(name = "post_id")
    val postId: Int,
    @ColumnInfo(name = "comment")
    val comment: String
) {
}