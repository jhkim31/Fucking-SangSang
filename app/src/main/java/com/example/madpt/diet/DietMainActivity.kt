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
import com.example.madpt.main.MainPageFragment
import java.time.LocalDateTime




class DietMainActivity : AppCompatActivity(), PostDietList {
    private lateinit var binding: ActivityDietMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDietMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.breakfastButton.setOnClickListener {
            val intent = Intent(this, DietInputActivity::class.java)
            startActivity(intent)
        }
        binding.lunchButton.setOnClickListener {
            val intent = Intent(this, DietInputActivity::class.java)
            startActivity(intent)
        }
        binding.dinnerButton.setOnClickListener {
            val intent = Intent(this, DietInputActivity::class.java)
            startActivity(intent)
        }
        binding.snackButton.setOnClickListener {
            val intent = Intent(this, DietInputActivity::class.java)
            startActivity(intent)
        }

        binding.backMove.setOnClickListener {
            finish()
        }
    }




    override fun postDietList() {
        val intent = Intent(this, MainActivity::class.java)
        AddFoodList.clear()
        startActivity(intent)
        finish()
    }
}

