package project.wgtech.limited.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import project.wgtech.limited.R
import project.wgtech.limited.databinding.FragmentItemBinding

class ItemFragment : Fragment(R.layout.fragment_item) {
    private val TAG = this.javaClass.simpleName

    private var _binding: FragmentItemBinding? = null
    private val binding get() = _binding!!

    private lateinit var item: Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = arguments?.getSerializable("item") as Item
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            Navigation.findNavController(requireActivity(), R.id.fragment_nav_host).popBackStack(R.id.fragment_main, false)
            // ... OR
            // Navigation.findNavController(requireActivity(), R.id.fragment_nav_host).navigate(R.id.action_fragment_item_to_fragment_main)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemBinding.inflate(inflater)
        binding.let {
            it.textViewItemTitle.text = item.title
            it.textViewItemDesc.text = item.description
            it.toolbarItem.setNavigationOnClickListener {
                Navigation.findNavController(requireActivity(), R.id.fragment_nav_host).popBackStack(R.id.fragment_main, false)
                // ... OR
                // Navigation.findNavController(requireActivity(), R.id.fragment_nav_host).navigate(R.id.action_fragment_item_to_fragment_main)
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}