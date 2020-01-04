package com.example.poke.view

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.jetpackcomponentsapp.R
import com.example.poke.MainViewModel
import com.example.poke.view.fragment.AddFragment
import com.example.poke.view.fragment.MainFragment
import com.example.poke.view.fragment.UpdateFragment

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            callMainFragment()
            viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        }
    }


    private fun callMainFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
    }

    fun callAddFragment() {
        supportFragmentManager.beginTransaction()
                .add(R.id.container, AddFragment.newInstance())
                .addToBackStack("AddFragment").commit()
    }

    fun callUpdateFragment() {
        UpdateFragment
                .newInstance()
                .show(supportFragmentManager.beginTransaction(),"UpdateFragment")
    }

    fun showSoftKeyboard(activity: Activity, showKeyboard : Boolean) {
        var view = activity.currentFocus
        when(showKeyboard){
            true -> {
                val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
            }
            false ->{
                val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager

                if (view == null) {
                    view = View(activity)
                }
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        }
        else {
            supportFragmentManager.popBackStack()
        }
    }
}