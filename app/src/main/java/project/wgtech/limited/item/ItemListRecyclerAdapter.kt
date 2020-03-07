package project.wgtech.limited.item

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.sub_item.view.*
import project.wgtech.limited.R
import project.wgtech.limited.databinding.ListItemBinding

class ItemListRecyclerAdapter(private var rootBinding: ListItemBinding, @Nullable var items: MutableList<Item>): RecyclerView.Adapter<ItemListRecyclerAdapter.ItemViewHolder>() {
    private val TAG = this.javaClass.simpleName

    private lateinit var context: Context

    inner class ItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.sub_item, parent, false)) {

        val cardView: CardView = itemView.cardView_list_item
        val imageView: AppCompatImageView = itemView.imageView_list_image
        val textViewTitle: AppCompatTextView = itemView.textView_list_title
        val textViewDesc: AppCompatTextView = itemView.textView_list_desc
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ItemViewHolder {
        context = parent.context
        return ItemViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        items[position].let { item ->
            with(holder) {
                textViewTitle.text = item.title
                textViewDesc.text = item.description

                val args = Bundle()
                args.putSerializable("item", item)

                cardView.setOnClickListener {
//                    val extras = FragmentNavigatorExtras(
//                        textViewTitle to "textViewTitle",
//                        textViewDesc to "textViewDesc"
//                    )
//                    Navigation.findNavController(rootBinding.root).navigate(R.id.action_fragment_main_to_fragment_item, args, null, extras)
                    Navigation.findNavController(rootBinding.root).navigate(R.id.action_fragment_main_to_fragment_item, args)
                }
            }
        }
    }
}