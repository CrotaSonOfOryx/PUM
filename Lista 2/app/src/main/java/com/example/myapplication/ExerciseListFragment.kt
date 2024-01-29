// ExerciseListFragment.kt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ExerciseList
import com.example.myapplication.R

class ExerciseListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ExerciseListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_exercise_list, container, false)
        recyclerView = view.findViewById(R.id.recycler_view_exercise_list)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Use the generated data
        val dummyData = DataGenerator.dummyData

        adapter = ExerciseListAdapter(dummyData, object : ExerciseListAdapter.OnItemClickListener {
            override fun onItemClick(exerciseList: ExerciseList) {
                val detailsFragment = ExerciseListDetailsFragment()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, detailsFragment)
                    .addToBackStack(null)
                    .commit()
            }
        })

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }
}
