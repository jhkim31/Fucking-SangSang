package com.example.madpt.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.madpt.databinding.FragmentCommunityMainBinding

class CommunityMainFragment : Fragment() {
    private lateinit var _binding: FragmentCommunityMainBinding
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCommunityMainBinding.inflate(inflater, container, false)

        binding.infoBtn.setOnClickListener {
            binding.noticeBoardList.visibility = View.INVISIBLE
            binding.infoNoticeBoard.visibility = View.VISIBLE
        }

        binding.backMove.setOnClickListener {
            if (binding.infoNoticeBoard.visibility==View.VISIBLE){
                binding.infoNoticeBoard.visibility = View.INVISIBLE
                binding.noticeBoardList.visibility = View.VISIBLE
            }
        }
        return binding.root
    }
}