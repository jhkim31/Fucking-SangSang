package com.example.madpt

import androidx.appcompat.app.AppCompatActivity
import com.example.madpt.databinding.ActivityMainBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.madpt.community.CommunityMainFragment
import com.example.madpt.main.GoalSetPageFragment
import com.example.madpt.main.MainPageFragment
import com.example.madpt.main.MainPageFragment2
import com.example.madpt.main.PutWeightDialog
import com.example.madpt.more.MoreFragment
import com.example.madpt.social.SocialFragment
import com.example.madpt.statistics.StatisticsFragment
import com.example.madpt.trainer.ChatFragment
import com.example.madpt.trainer.CustInfoFragment
import com.example.madpt.training.TrainingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.fl_container, MainPageFragment2(), "main").commit()

        binding.bnvMain.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.main -> {
                        changeFragment(MainPageFragment2(),"main")
                    }
                    R.id.social -> {
                        changeFragment(SocialFragment(),"social")
                    }
                    R.id.community -> {
                        changeFragment(CommunityMainFragment(),"social")
                    }
                    else -> {
                        changeFragment(MoreFragment(),"more")
                    }
                }
            true
        }
    }

    private fun changeFragment(fragment: Fragment, name : String){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container, fragment, name)
            .addToBackStack(null)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }

    fun updateBottomMenu(navigation: BottomNavigationView) {
        val tag1: Fragment? = supportFragmentManager.findFragmentByTag("main")
        val tag2: Fragment? = supportFragmentManager.findFragmentByTag("social")
        val tag3: Fragment? = supportFragmentManager.findFragmentByTag("community")
        val tag4: Fragment? = supportFragmentManager.findFragmentByTag("more")

        if(tag1 != null && tag1.isVisible) navigation.menu.findItem(R.id.main).isChecked = true
        else if(tag2 != null && tag2.isVisible) navigation.menu.findItem(R.id.social).isChecked = true
        else if(tag3 != null && tag3.isVisible) navigation.menu.findItem(R.id.social).isChecked = true
        else if(tag4 != null && tag4.isVisible) navigation.menu.findItem(R.id.more).isChecked = true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val bnv = findViewById<View>(R.id.bnv_main) as BottomNavigationView
        updateBottomMenu(bnv)
    }

    fun setFragment() {
        val transaction = supportFragmentManager.beginTransaction()
            .add(R.id.fl_container, MainPageFragment())
        transaction.commit()
    }

    fun changeGoalSettingFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fl_container, GoalSetPageFragment())
        transaction.commit()
    }

    fun showMessageDialog(){
        val customDialog = PutWeightDialog(finishApp = {finish()})
        customDialog.show(supportFragmentManager, "PutWeightDialog")
    }

    fun changeFragment(index: Int){
        when(index){
            1 -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.fl_container, ChatFragment())
                transaction.commit()
            }

            2 -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.fl_container, CustInfoFragment())
                transaction.commit()
            }

            3 ->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fl_container, StatisticsFragment())
                    .addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit()
            }

        }
    }

}