import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.csi.R

class ContentAdapter(
    private val items: MutableList<ContentModel>,
    private val onItemClick: (ContentModel) -> Unit
) : RecyclerView.Adapter<ContentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_content_list, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleArea)
        private val contentTextView: TextView = itemView.findViewById(R.id.contentArea)
        private val timeTextView: TextView = itemView.findViewById(R.id.timeArea)
        private val likeTextView: TextView = itemView.findViewById(R.id.likesCount)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(items[position])
                }
            }
        }

        fun bind(contentModel: ContentModel) {
            titleTextView.text = contentModel.title
            contentTextView.text = contentModel.content
            timeTextView.text = contentModel.time
            likeTextView.text = contentModel.likes.toString()

        }
    }
}