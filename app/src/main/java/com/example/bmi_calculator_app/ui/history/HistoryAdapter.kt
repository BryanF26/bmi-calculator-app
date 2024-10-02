import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bmi_calculator_app.R
import com.example.bmi_calculator_app.model.HistoryEntry

class HistoryAdapter(private var historyList: List<HistoryEntry> = emptyList()) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val weightText: TextView = itemView.findViewById(R.id.weight_text)
        val heightText: TextView = itemView.findViewById(R.id.height_text)
        val bmiText: TextView = itemView.findViewById(R.id.bmi_text)
        val categoryText: TextView = itemView.findViewById(R.id.category_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.history_item, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item = historyList[position]
        holder.weightText.text = "${item.weight} kg"
        holder.heightText.text = "${item.height} cm"
        holder.bmiText.text = String.format("%.2f", item.bmi)
        holder.categoryText.text = "${item.category}"
    }

    override fun getItemCount(): Int = historyList.size


    fun submitList(newHistory: List<HistoryEntry>) {
        val diffCallback = HistoryDiffCallback(historyList, newHistory)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        historyList = newHistory
        diffResult.dispatchUpdatesTo(this)
    }

    class HistoryDiffCallback(
        private val oldList: List<HistoryEntry>,
        private val newList: List<HistoryEntry>
    ) : DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size
        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}
