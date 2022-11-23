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

    var DataList = arrayListOf(
        Data("단백질 얼마나 먹어야 하나요?","김성환"," | 2022-11-21 |","30"),
        Data("운동 루틴 추천해주세요.","김재현"," | 2022-11-18 |","23"),
        Data("영양소도감, 마그네슘 Magnesium","김성환"," | 2022-11-17 |","27"),
        Data("단백질을 너무 많이 먹으면 위험하다.","문기렴"," | 2022-11-15 |","24"),
        Data("단백질은 가급적 적게 섭취하라.","김재현"," | 2022-11-14 |","29"),
        Data("비타민과 영양제 복용법","김재현"," | 2022-11-13 |","34"),
        Data("외모가 늙어 보이면 몸속도 늙었다!","문기렴"," | 2022-11-10 |","35"),
        Data("물과 소금이 꼭 필요한 경우","김정락"," | 2022-11-8 |","32"),
        Data("발암성이 있거나 간에 손상을 입힐 우려가 있는 합성감미료","김성환"," | 2022-11-7 |","27"),
        Data("논문을 통해 본 운동시 카페인 섭취의 타이밍","김성환"," | 2022-11-5 |","29"),
        Data("웨이트랑 같이하면 좋은운동","문기렴"," | 2022-11-4 |","43")
    )

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

        binding.textList.adapter = CustomAdapter(requireContext(),DataList)
        return binding.root
    }
}