package ir.aminrahkan.instagramsample.data.model


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/12/22 - 2022
// Project name : Instagram Sample


data class PostModel(
    val postId: Int,
    val user: UserModel,
    val imageAddress: String,
    val isLiked: Boolean,
    val likeCount: Int,
    val commentCount: Int
)
