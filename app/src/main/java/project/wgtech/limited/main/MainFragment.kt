package project.wgtech.limited.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import project.wgtech.limited.R
import project.wgtech.limited.databinding.FragmentMainBinding
import project.wgtech.limited.item.FeaturedItemFragment
import project.wgtech.limited.item.HotItemFragment
import project.wgtech.limited.item.Item
import project.wgtech.limited.item.NewItemFragment
import java.lang.IllegalArgumentException

class MainFragment : Fragment(R.layout.fragment_main) {
    private val TAG = this.javaClass.simpleName

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var items: MutableList<Item>
    private lateinit var items2: MutableList<Item>
    private lateinit var items3: MutableList<Item>

    private lateinit var pageChangedCallback: OnPageChangedCallback

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        items = mutableListOf(
            Item.Builder().id(1).title("Hello Title").description("Hello Desc").build(),
            Item.Builder().id(2).title("Hello Title2").description("Hello Desc2").build(),
            Item.Builder().id(3).title("Hello Title3").description("Hello Desc3").build(),
            Item.Builder().id(4).title("Hello Title4").description("Hello Desc4").build(),
            Item.Builder().id(5).title("Hello Title5").description("Hello Desc5").build()
        )
        items2 = mutableListOf(
            Item.Builder().id(4).title("Hello Title4").description("Hello Desc4").build(),
            Item.Builder().id(5).title("Hello Title5").description("Hello Desc5").build(),
            Item.Builder().id(6).title("Hello Title6").description("Hello Desc6").build(),
            Item.Builder().id(7).title("Hello Title7").description("Hello Desc7").build()
        )
        items3 = mutableListOf(
            Item.Builder().id(8).title("Hello Title8").description("Hello Desc8").build(),
            Item.Builder().id(9).title("Hello Title9").description("Hello Desc9").build(),
            Item.Builder().id(10).title("Hello Title10").description("Hello Desc10").build(),
            Item.Builder().id(11).title("Hello Title11").description("Hello Desc11").build(),
            Item.Builder().id(12).title("Hello Title12").description("Hello Desc12").build(),
            Item.Builder().id(13).title("Hello Title12").description("Hello Desc12").build(),
            Item.Builder().id(14).title("Hello Title12").description("Hello Desc12").build(),
            Item.Builder().id(15).title("Hello Title12").description("Hello Desc12").build(),
            Item.Builder().id(16).title("Hello Title12").description("Hello Desc12").build(),
            Item.Builder().id(17).title("Hello Title12").description("Hello Desc12").build()
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater)

        val tabLayout : TabLayout = binding.tabLayoutMain
        val toolbar : Toolbar = binding.toolbarMain
        val viewPager : ViewPager2 = binding.viewPager2Main
        val titles = listOf<String>(getString(R.string.main_menu_featured),
            getString(R.string.main_menu_hot),
            getString(R.string.main_menu_new))
        pageChangedCallback = OnPageChangedCallback(titles, toolbar)

        viewPager.adapter = TabsAdapter(childFragmentManager, lifecycle)
        viewPager.registerOnPageChangeCallback(pageChangedCallback)
        viewPager.isUserInputEnabled = true
        viewPager.currentItem = 0

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = titles[0]
                1 -> tab.text = titles[1]
                2 -> tab.text = titles[2]
                else -> throw IllegalArgumentException()
            }
            viewPager.setCurrentItem(tab.position, true)
        }.attach()

        return binding.root
    }


    inner class TabsAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
        private val TAG = this.javaClass.simpleName

        override fun createFragment(position: Int): Fragment {
            val fragment: Fragment
            when (position) {
                0 -> fragment = FeaturedItemFragment(items)
                1 -> fragment = HotItemFragment(items2)
                2 -> fragment = NewItemFragment(items3)
                else -> throw IllegalArgumentException()
            }
            return fragment
        }
        override fun getItemCount(): Int = 3
    }


    override fun onDestroyView() {
        val viewPager : ViewPager2 = binding.viewPager2Main
        viewPager.unregisterOnPageChangeCallback(pageChangedCallback)
        _binding = null
        super.onDestroyView()
    }
}