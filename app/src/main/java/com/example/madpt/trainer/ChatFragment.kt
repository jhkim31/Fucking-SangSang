package com.example.madpt.trainer

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.madpt.MainActivity
import com.example.madpt.R
import com.example.madpt.databinding.FragmentChatBinding
import com.example.madpt.splash.SplashActivity

class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!
    var mainActivity: MainActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as? MainActivity?
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChatBinding.inflate(inflater, container, false)

        binding.nextInfoPage.setOnClickListener{
            mainActivity!!.changeFragment(2)
        }
        return binding.root
    }
}