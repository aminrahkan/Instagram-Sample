package ir.aminrahkan.instagramsample.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import ir.aminrahkan.instagramsample.R
import ir.aminrahkan.instagramsample.data.db.entities.Comment
import ir.aminrahkan.instagramsample.databinding.FragmentDetailBinding
import ir.aminrahkan.instagramsample.presentation.ui.detail.adapter.CommentListAdapter
import ir.aminrahkan.instagramsample.presentation.ui.detail.adapter.CommentLoadStateAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/11/22 - 2022
// Project name : Instagram Sample

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private val detailModelView: DetailModelView by viewModels()
    private lateinit var binding: FragmentDetailBinding
    private lateinit var adapter: CommentListAdapter
    private val args: DetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivAvatar.load(args.post.userAvatar)
        binding.ivMyAvatar.load(args.post.userAvatar)//Must be user profile
        binding.tvUserName.text = args.post.userName
        binding.tvCaption.text = args.post.caption

        if (args.post.isLiked) binding.ivLike.setImageResource(R.drawable.ic_like) else binding.ivLike.setImageResource(
            R.drawable.ic_no_like
        )

        initMember()
        initAdapter()
        iniViews()
        fetchCommentsList()
    }

    private fun fetchCommentsList() {

        lifecycleScope.launch {
            detailModelView.getCommentsFromDb(args.post.postId).distinctUntilChanged()
                .collectLatest {
                    adapter.submitData(it)

                }
        }
    }

    private fun iniViews() {
        binding.btnPostComment.setOnClickListener {
            lifecycleScope.launch {

                if (binding.edComment.text.isNotEmpty()) {
                    detailModelView.insertComment(
                        Comment(
                            0,
                            args.post.postId,
                            binding.edComment.text.toString()
                        )
                    )

                    fetchCommentsList()
                    delay(500)
                    withContext(Dispatchers.Main) {
                        binding.edComment.text.clear()
                        Toast.makeText(
                            context,
                            "Your Comment Saved",
                            Toast.LENGTH_LONG
                        ).show()

                        binding.rvCommentList.layoutManager?.scrollToPosition(0)
                    }


                }
            }
        }

        binding.ivLike.setOnClickListener {
            if (args.post.isLiked) {
                binding.ivLike.setImageResource(R.drawable.ic_no_like)
                args.post.isLiked = false
            } else {
                binding.ivLike.setImageResource(R.drawable.ic_like)
                args.post.isLiked = true
            }

            lifecycleScope.launch {
                detailModelView.updatePostLikeValue(args.post)
            }
        }

    }

    private fun initMember() {
        adapter = CommentListAdapter()
    }

    private fun initAdapter() {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        binding.rvCommentList.layoutManager = layoutManager
        binding.rvCommentList.adapter = adapter.withLoadStateFooter(
            CommentLoadStateAdapter()
        )
    }


}