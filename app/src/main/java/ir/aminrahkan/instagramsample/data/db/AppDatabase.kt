package ir.aminrahkan.instagramsample.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.aminrahkan.instagramsample.data.db.entities.Post


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/13/22 - 2022
// Project name : Instagram Sample

@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

}