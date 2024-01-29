import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class GradeListAdapter(private val data: List<GradeListData>) : RecyclerView.Adapter<GradeListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectName: TextView = itemView.findViewById(R.id.text_subject_name)
        val averageGradeLabel: TextView = itemView.findViewById(R.id.text_average_grade_label)
        val averageGrade: TextView = itemView.findViewById(R.id.text_average_grade)
        val listCount: TextView = itemView.findViewById(R.id.text_list_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_grade_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = data[position]

        holder.subjectName.text = currentItem.subjectName
        holder.averageGrade.text = "Average Grade: ${currentItem.averageGrade}"
        holder.listCount.text = "Lists: ${currentItem.listCount}"
    }

    override fun getItemCount() = data.size
}