package ir.aminrahkan.instagramsample.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import ir.aminrahkan.instagramsample.data.db.entities.Comment


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/13/22 - 2022
// Project name : Instagram Sample


@Dao
interface CommentDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertAllComment(remoteKey: List<Comment>)

    @Insert(onConflict = REPLACE)
    suspend fun insertComment(comment: Comment)

    @Query("SELECT * FROM comment_table WHERE post_id=:postId ORDER BY id DESC LIMIT :limit OFFSET :offset  ")
    suspend fun getCommentsByPostId(limit: Int, offset: Int,postId:Int): List<Comment>

}