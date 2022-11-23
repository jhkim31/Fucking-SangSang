package com.example.madpt.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.madpt.*
import com.example.madpt.API.food.GetSummaryData
import com.example.madpt.API.statistic.GetSummaryDataCall
import com.example.madpt.API.statistic.SummaryData
import com.example.madpt.databinding.FragmentMainPage2Binding
import com.example.madpt.diet.DietMainActivity


class MainPageFragment2 : Fragment(), GetSummaryData {


    private var _binding: FragmentMainPage2Binding? = null
    private val binding get() = _binding!!

    var mainActivity: MainActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as? MainActivity?
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainPage2Binding.inflate(inflater, container, false)

        GetSummaryDataCall(this, requireContext()).getSummaryData()


        binding.goalButton.setOnClickListener() {
            mainActivity!!.changeGoalSettingFragment()
        }

        binding.plusButtonWeight.setOnClickListener() {
            mainActivity!!.showMessageDialog()
        }

        binding.userWeight.setOnClickListener() {
            mainActivity!!.showMessageDialog()
        }

        binding.exerciseButton.setOnClickListener() {
            mainActivity!!.changeFragment(4)
        }

        binding.dietButton.setOnClickListener {
            val intent = Intent(context, DietMainActivity::class.java)
            startActivity(intent)
        }

        binding.staticButton.setOnClickListener {
            mainActivity!!.changeFragment(3)
        }

        binding.trainerButton.setOnClickListener {
            mainActivity!!.changeFragment(1)
        }
        return binding.root
    }

    override fun getSummaryDataList(summaryData: SummaryData) {

        val userWeight = summaryData.weight.toInt().toString() + "Kg"
        binding.plusButtonWeight.visibility = View.INVISIBLE
        binding.userWeight.visibility = View.VISIBLE
        binding.userWeight.text = userWeight

        //유저 weight있을 시 weight 출력

        if (summaryData.weight != 0.0 && summaryData.goalweight != 0.0) {
            val userGoalWeightRemain = (summaryData.goalweight - summaryData.weight).toInt()
            if (userGoalWeightRemain >= 0) {
                binding.postGoalDistance.text = "목표 몸무게를 달성했습니다!"
                binding.weightGoalLayout.visibility = View.INVISIBLE
                binding.postGoalDistance.visibility = View.VISIBLE
            }
            if (userGoalWeightRemain < 0) {
                binding.goalDistance.text = userGoalWeightRemain.toString() + "kg 입니다."
                binding.goalDistance.visibility = View.VISIBLE
                binding.postGoalDistance.visibility = View.INVISIBLE
            }
        }

        if (summaryData.goalweight == 0.0) {
            binding.weightGoalLayout.visibility = View.INVISIBLE
            binding.postGoalDistance.visibility = View.VISIBLE
        }

        val sumKcal: String =
            (summaryData.snackKcal + summaryData.breakfastKcal + summaryData.lunchKcal + summaryData.dinnerKcal).toInt()
                .toString()
        binding.eatKcal.text = sumKcal
        //총합 Kcal 출력

        var lessKcal: Int = summaryData.goaldietkcal.toInt() - sumKcal.toInt()
        if (lessKcal < 0 || summaryData.goaldietkcal == 0.0) lessKcal = 0
        binding.arcProgress.progress = lessKcal
        binding.arcProgress.max = summaryData.goaldietkcal.toInt()
        //잔여 kcal 출력

        binding.moveKcal.text = summaryData.exerciseKcal.toInt().toString()
        //활동 칼로리 출력

    }
}