import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ExerciseList
import com.example.myapplication.R
import kotlin.math.roundToInt

class GradeListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: GradeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_grade_list, container, false)
        recyclerView = view.findViewById(R.id.recycler_view_grade_list)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Use the generated data
        val dummyData = DataGenerator.dummyData

        // Calculate average grades and list counts
        val averageGrades = calculateAverageGrades(dummyData)
        val listCounts = calculateListCounts(dummyData)

        // Combine the data into a list of com.example.myapplication.GradeListData
        val gradeListData = averageGrades.keys.map { subjectName ->
            GradeListData(
                subjectName = subjectName,
                averageGrade = averageGrades[subjectName] ?: 0.0,
                listCount = listCounts[subjectName] ?: 0
            )
        }

        adapter = GradeListAdapter(gradeListData)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    private fun calculateListCounts(data: List<ExerciseList>): Map<String, Int> {
        val result = mutableMapOf<String, Int>()

        data.forEach { exerciseList ->
            val subjectName = exerciseList.subject.name
            val currentCount = result[subjectName] ?: 0
            result[subjectName] = currentCount + 1
        }

        return result
    }

    private fun calculateAverageGrades(data: List<ExerciseList>): Map<String, Double> {
        val result = mutableMapOf<String, Double>()

        data.forEach { exerciseList ->
            val subjectName = exerciseList.subject.name
            val currentAverage = result[subjectName] ?: 0.0
            val newAverage = (currentAverage + exerciseList.grade) / 2
            // Round the newAverage to halves
            result[subjectName] = (newAverage * 2).roundToInt() / 2.0
        }

        return result
    }
}