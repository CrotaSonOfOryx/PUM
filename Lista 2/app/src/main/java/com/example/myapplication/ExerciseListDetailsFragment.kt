// ExerciseListDetailsFragment.kt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ExerciseList
import com.example.myapplication.R
import com.example.myapplication.Subject
import kotlin.random.Random

class ExerciseListDetailsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TaskListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_exercise_list_details, container, false)
        recyclerView = view.findViewById(R.id.recycler_view_tasks)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectedExerciseList: ExerciseList = getSelectedExerciseList()

        // Generate random tasks based on the selected ExerciseList
        val tasks = generateRandomTasks(selectedExerciseList)

        adapter = TaskListAdapter(tasks)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    private fun generateRandomTasks(exerciseList: ExerciseList): List<Task> {
        val tasks = mutableListOf<Task>()
        val numberOfTasks = Random.nextInt(1, 11)

        for (i in 1..numberOfTasks) {
            val taskContent = "Lorem ipsum task $i"
            val taskPoints = Random.nextInt(1, 11)
            val task = Task(taskContent, taskPoints)
            tasks.add(task)
        }

        return tasks
    }

    private fun getSelectedExerciseList(): ExerciseList {
        return ExerciseList(
            subject = Subject("Dummy Subject"),
            exercises = emptyList(),
            grade = 0.0
        )
    }
}
