package com.example.madpt.trainer

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.madpt.MainActivity
import com.example.madpt.databinding.FragmentCustInfoBinding
import com.example.madpt.splash.SplashActivity

class CustInfoFragment : Fragment() {
    private var _binding: FragmentCustInfoBinding?= null
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
        _binding = FragmentCustInfoBinding.inflate(inflater, container, false)
        Glide.with(this).load(SplashActivity.userProfile).into(binding.profileCust1)
        Glide.with(this).load(SplashActivity.userProfile).into(binding.profileCust2)

        val mActivity = activity as MainActivity
        binding.backMove.setOnClickListener{
            mainActivity!!.changeFragment(1)
        }

        return binding.root
    }
}