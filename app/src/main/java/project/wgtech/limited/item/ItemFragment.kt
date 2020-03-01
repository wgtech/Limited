package project.wgtech.limited.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import project.wgtech.limited.R
import project.wgtech.limited.databinding.SubItemBinding

class ItemFragment() : Fragment(R.layout.sub_item) {
    private val TAG = this.javaClass.simpleName

    private var _binding: SubItemBinding? = null
    private val binding get() = _binding!!

    private lateinit var item: Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = arguments?.getSerializable("item") as Item
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SubItemBinding.inflate(inflater)
        binding.textViewListTitle.text = item.title
        binding.textViewListDesc.text = item.description

        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}