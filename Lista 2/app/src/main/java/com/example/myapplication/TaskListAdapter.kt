// TaskListAdapter.kt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class TaskListAdapter(private val tasks: List<Task>) : RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskNumber: TextView = itemView.findViewById(R.id.text_task_number)
        val taskDescription: TextView = itemView.findViewById(R.id.text_task_description)
        val taskPoints: TextView = itemView.findViewById(R.id.text_task_points)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = tasks[position]

        // Populate task number, description, and points
        holder.taskNumber.text = "Task #${position + 1}"
        holder.taskDescription.text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
        holder.taskPoints.text = "Points: ${task.points}"
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}
