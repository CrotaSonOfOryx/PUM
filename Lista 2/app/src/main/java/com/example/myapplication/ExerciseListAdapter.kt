// ExerciseListAdapter.kt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ExerciseList
import com.example.myapplication.R

class ExerciseListAdapter(
    private val exerciseLists: List<ExerciseList>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<ExerciseListAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(exerciseList: ExerciseList)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectName: TextView = itemView.findViewById(R.id.text_subject_name)
        val grade: TextView = itemView.findViewById(R.id.text_grade)
        val exerciseCount: TextView = itemView.findViewById(R.id.text_exercise_count)
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListener.onItemClick(exerciseLists[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exercise_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exerciseList = exerciseLists[position]

        holder.subjectName.text = exerciseList.subject.name
        holder.grade.text = exerciseList.grade.toString()
        holder.exerciseCount.text = "Tasks: ${exerciseList.exercises.size}"
    }

    override fun getItemCount(): Int {
        return exerciseLists.size
    }
}
