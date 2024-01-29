import com.example.myapplication.Exercise
import com.example.myapplication.ExerciseList
import com.example.myapplication.Subject

// DataGenerator.kt
object DataGenerator {
    var isDataInitialized = false
    lateinit var dummyData: List<ExerciseList>
        private set

    private fun generateDummyData(): List<ExerciseList> {
        val subjects = listOf("Matematyka", "PUM", "Fizyka", "Elektronika", "Algorytmy")
        val data = mutableListOf<ExerciseList>()

        repeat(20) {
            val subject = Subject(subjects.random())
            val grade = (3.0 + (0..4).random() * 0.5)
            val numExercises = (1..10).random()

            val exercises = List(numExercises) {
                Exercise("Lorem ipsum task ${it + 1}", (1..10).random())
            }

            data.add(ExerciseList(subject, grade, exercises))
        }
        isDataInitialized = true
        return data
    }
    fun initializeData() {
        if (!isDataInitialized) {
            dummyData=generateDummyData()
        }
    }
}
