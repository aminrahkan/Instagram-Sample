package ir.aminrahkan.instagramsample.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import ir.aminrahkan.instagramsample.data.local.db.entities.Post


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/13/22 - 2022
// Project name : Instagram Sample


@Dao
interface PostDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertAllPost(remoteKey: List<Post>)

    @Insert(onConflict = REPLACE)
    suspend fun insertPost(post: Post)

    @Query("SELECT * FROM posts_table ORDER BY id ASC LIMIT :limit OFFSET :offset")
    suspend fun getAllPost(limit: Int, offset: Int): List<Post>

    @Update(onConflict = REPLACE)
    suspend fun updatePost(post: Post)

}