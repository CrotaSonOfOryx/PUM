package com.example.myapplication

import ExerciseListFragment
import GradeListFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val exerciseListFragment = ExerciseListFragment()
    private val gradeListFragment = GradeListFragment()

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_exercise_list -> {
                    replaceFragment(exerciseListFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_grade_list -> {
                    replaceFragment(gradeListFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataGenerator.initializeData()

        setContentView(R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        replaceFragment(exerciseListFragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
data class Exercise(val content: String, val points: Int)

data class Subject(val name: String)

data class ExerciseList(val subject: Subject, val grade: Double, val exercises: List<Exercise>)