package com.example.madpt.diet

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.madpt.*
import com.example.madpt.API.diet.AddFoodList
import com.example.madpt.API.diet.PostDietListCall
import com.example.madpt.API.diet.daily_diet
import com.example.madpt.API.food.PostDietList
import com.example.madpt.databinding.ActivityDietMainBinding
import com.example.madpt.databinding.ActivityDietPageBinding
import com.example.madpt.main.MainPageFragment
import java.time.LocalDateTime

var dataSumKcal : Int = 0
var allSumKcal : Int = 0


class DietMainActivity : AppCompatActivity(), PostDietList {
    private lateinit var binding: ActivityDietMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityDietPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dietType = intent.getStringExtra("diet_type")

        binding.foodSearchIntentButton.setOnClickListener(){
            val intent = Intent(this,DietSearchActivity::class.java)
            startActivity(intent)
        }

        binding.customFoodIntentButton.setOnClickListener(){
            val intent = Intent(this,CustomFoodDataModifySaveActivity::class.java)
            startActivity(intent)
        }

        binding.dietSaveButton.setOnClickListener(){
            val saveDiet = daily_diet(date = System.currentTimeMillis(), diet_type = dietType!!,simple_total_kcal = sumSimpleKcal.toDouble(), diet_list = AddFoodList)
            PostDietListCall(this, this).PostDiet(saveDiet)
        }

    }

    override fun onRestart() {
        dataSumKcal = 0
        val foodListAdapter = FoodListViewAdapter(this, AddFoodList)
        binding.listview1.adapter = foodListAdapter
        setSumKcal()
        super.onRestart()
    }


    }
    fun setSumKcal(){
        dataSumKcal = 0
        for(i in AddFoodList.indices){
            dataSumKcal += AddFoodList[i].diet_kcal.toInt()
        }
        allSumKcal = dataSumKcal+sumSimpleKcal
        if(allSumKcal<=0) {
            allSumKcal = 0
            sumSimpleKcal = 0
        }
        binding.sumKcal.setText(allSumKcal.toString())
    }


    override fun postDietList() {
        val intent = Intent(this, MainActivity::class.java)
        AddFoodList.clear()
        startActivity(intent)
        finish()
    }
}