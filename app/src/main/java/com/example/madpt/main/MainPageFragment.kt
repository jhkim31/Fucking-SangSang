package com.example.madpt.main

import android.app.ProgressDialog.show
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.madpt.*
import com.example.madpt.API.food.GetSummaryData
import com.example.madpt.API.statistic.GetSummaryDataCall
import com.example.madpt.API.statistic.SummaryData
import com.example.madpt.databinding.FragmentMainPageBinding
import com.example.madpt.diet.DietPageActivity

class MainPageFragment : Fragment(), GetSummaryData {


    private var _binding: FragmentMainPageBinding? = null
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

        _binding = FragmentMainPageBinding.inflate(inflater, container, false)

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

        binding.plusButtonBreakfast.setOnClickListener() {
            val intent = Intent(context, DietPageActivity::class.java)
            intent.putExtra("diet_type", "Breakfast")
            startActivity(intent)
        }

        binding.plusButtonLunch.setOnClickListener() {
            val intent = Intent(context, DietPageActivity::class.java)
            intent.putExtra("diet_type", "Lunch")
            startActivity(intent)
        }

        binding.plusButtonDinner.setOnClickListener() {
            val intent = Intent(context, DietPageActivity::class.java)
            intent.putExtra("diet_type", "Dinner")
            startActivity(intent)
        }

        binding.plusButtonSnack.setOnClickListener() {
            val intent = Intent(context, DietPageActivity::class.java)
            intent.putExtra("diet_type", "Snack")
            startActivity(intent)
        }


        return binding.root
    }

    override fun getSummaryDataList(summaryData: SummaryData) {
        if (summaryData.breakfastKcal != 0.0) {
            val sum: String = summaryData.breakfastKcal.toInt().toString() + " kcal"
            binding.plusButtonBreakfast.visibility = View.INVISIBLE
            binding.breakfastKcalText.visibility = View.VISIBLE
            binding.breakfastKcalText.text = sum
        }
        if (summaryData.lunchKcal != 0.0) {
            val sum: String = summaryData.lunchKcal.toInt().toString() + " kcal"
            binding.plusButtonLunch.visibility = View.INVISIBLE
            binding.lunchKcalText.visibility = View.VISIBLE
            binding.lunchKcalText.text = sum
        }
        if (summaryData.dinnerKcal != 0.0) {
            val sum: String = summaryData.dinnerKcal.toInt().toString() + " kcal"
            binding.plusButtonDinner.visibility = View.INVISIBLE
            binding.dinnerKcalText.visibility = View.VISIBLE
            binding.dinnerKcalText.text = sum
        }
        if (summaryData.snackKcal != 0.0) {
            val sum: String = summaryData.snackKcal.toInt().toString() + " kcal"
            binding.plusButtonSnack.visibility = View.INVISIBLE
            binding.snackKcalText.visibility = View.VISIBLE
            binding.snackKcalText.text = sum
        }
        //?????? Kcal?????? ??? Kcal ??????


        val userWeight = summaryData.weight.toInt().toString() + "Kg"
        binding.plusButtonWeight.visibility = View.INVISIBLE
        binding.userWeight.visibility = View.VISIBLE
        binding.userWeight.text = userWeight

        //?????? weight?????? ??? weight ??????

        if (summaryData.weight != 0.0 && summaryData.goalweight != 0.0) {
            val userGoalWeightRemain = (summaryData.goalweight - summaryData.weight).toInt()
            if (userGoalWeightRemain >= 0) {
                binding.postGoalDistance.text = "?????? ???????????? ??????????????????!"
                binding.weightGoalLayout.visibility = View.INVISIBLE
                binding.postGoalDistance.visibility = View.VISIBLE
            }
            if (userGoalWeightRemain < 0) {
                binding.goalDistance.text = userGoalWeightRemain.toString() + "kg ?????????."
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
        //?????? Kcal ??????

        var lessKcal: Int = summaryData.goaldietkcal.toInt() - sumKcal.toInt()
        if (lessKcal < 0 || summaryData.goaldietkcal == 0.0) lessKcal = 0
        binding.arcProgress.progress = lessKcal
        binding.arcProgress.max = summaryData.goaldietkcal.toInt()
        //?????? kcal ??????

        binding.moveKcal.text = summaryData.exerciseKcal.toInt().toString()
        //?????? ????????? ??????

    }
}