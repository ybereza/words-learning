package com.example.words_learning

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.words_learning.database.Model
import com.example.words_learning.fragments.dictionary.DictionaryFragment
import com.example.words_learning.fragments.search.SearchWord


class MainApplication : AppCompatActivity() {

    lateinit var router  : Router
    private lateinit var model: Model


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                router.navigateTo(false, :: MainFragment, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_book -> {
                //router.navigateTo(false, ::DictionaryFragment, true)
                //return@OnNavigationItemSelectedListener true
                model.addValue("adsa")
                val listView = this.findViewById<TextView>(R.id.textView2)
                listView.setText(model.text(0))

            }
            R.id.navigation_search -> {
                router.navigateTo(false, ::SearchWord, true)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        model = Model(this) //тут падает, не понимаю почему, помогите, пожалуйста

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_application)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.selectedItemId = R.id.navigation_home
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)


        router = Router(this, R.id.fragment_container)
        if (savedInstanceState == null)
            router.navigateTo(false, ::MainFragment)
    }


    override fun onBackPressed() {
        if (!router.navigateBack()) {
            super.onBackPressed()
        }
    }

    override fun onResume() {
        super.onResume()
    }



    override fun onPause() {
        super.onPause()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {


    }



}