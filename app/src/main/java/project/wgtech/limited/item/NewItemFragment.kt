package project.wgtech.limited.item

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import project.wgtech.limited.R
import project.wgtech.limited.databinding.ListItemBinding

class NewItemFragment(@Nullable val items: MutableList<Item>) : Fragment(R.layout.list_item) {
    private val TAG = this.javaClass.simpleName

    private var _binding: ListItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ListItemBinding.inflate(inflater)
        binding.recyclerViewList.adapter = ItemListRecyclerAdapter(requireActivity(), items)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}