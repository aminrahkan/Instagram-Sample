package ir.aminrahkan.instagramsample.presentation.ui.wall

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.aminrahkan.instagramsample.databinding.FragmentWallBinding


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/11/22 - 2022
// Project name : Instagram Sample


class WallFragment : Fragment() {

    lateinit var binding: FragmentWallBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWallBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}