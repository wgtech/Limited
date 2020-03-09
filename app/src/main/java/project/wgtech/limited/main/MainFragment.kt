package project.wgtech.limited.main

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import project.wgtech.limited.R
import project.wgtech.limited.databinding.FragmentMainBinding
import project.wgtech.limited.item.*
import java.lang.IllegalArgumentException

class MainFragment : Fragment(R.layout.fragment_main), Toolbar.OnMenuItemClickListener {
    private val TAG = this.javaClass.simpleName

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var fragments: MutableList<Fragment>
    private lateinit var titles: MutableList<String>
    private lateinit var icons: MutableList<Drawable>

    private lateinit var items: MutableList<Item>
    private lateinit var items2: MutableList<Item>
    private lateinit var items3: MutableList<Item>
    private lateinit var items4: MutableList<Item>

    private lateinit var tabLayout : TabLayout
    private var isViewTypeList : Boolean = true
    private lateinit var toolbar : Toolbar
    private lateinit var viewPager : ViewPager2
    private lateinit var callback: OnPageChangedCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
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
        items4 = mutableListOf(
            Item.Builder().id(18).title("Custom1").description("Custom1 Desc").build(),
            Item.Builder().id(19).title("Custom2").description("Custom2 Desc").build(),
            Item.Builder().id(20).title("Custom3").description("Custom3 Desc").build(),
            Item.Builder().id(21).title("Custom4").description("Custom4 Desc").build()
        )

        titles = mutableListOf(getString(R.string.main_menu_featured), getString(R.string.main_menu_hot), getString(R.string.main_menu_new))
        icons = mutableListOf(ContextCompat.getDrawable(context, R.drawable.round_star_outline_24)!!, ContextCompat.getDrawable(context, R.drawable.round_whatshot_24)!!, ContextCompat.getDrawable(context, R.drawable.outline_new_releases_24)!!)
        fragments = mutableListOf(FeaturedItemFragment(items), HotItemFragment(items2), NewItemFragment(items3))
        isViewTypeList = true
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater)

        tabLayout = binding.tabLayoutMain
        toolbar = binding.toolbarMain
        viewPager = binding.viewPager2Main

        viewPager.adapter = TabsAdapter(childFragmentManager, lifecycle, fragments)
        callback = OnPageChangedCallback(titles, toolbar)
        viewPager.registerOnPageChangeCallback(callback)
        viewPager.isUserInputEnabled = false
        viewPager.currentItem = 0

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = titles[position]
            tab.icon = icons[position]
            tabLayout.isInlineLabel = true
            viewPager.currentItem = tab.position
        }.attach()

        toolbar.setOnMenuItemClickListener(this)

        return binding.root
    }


    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item_search -> {
                Toast.makeText(context, "Search Icon", Toast.LENGTH_SHORT).show()
                fragments.add(SearchFragment(items4))
                titles.add("Custom")
                tabLayout.addTab(tabLayout.newTab().setText(titles[titles.size-1]), fragments.size-1, true)
                viewPager.adapter = TabsAdapter(childFragmentManager, lifecycle, fragments)
                callback = OnPageChangedCallback(titles, toolbar)
                viewPager.registerOnPageChangeCallback(callback)
            }

            R.id.item_view_type_change -> {
                Toast.makeText(context, "ViewType Changed", Toast.LENGTH_SHORT).show()
                if (isViewTypeList) {
                    item.icon = context?.getDrawable(R.drawable.round_view_day_24)
                } else {
                    item.icon = context?.getDrawable(R.drawable.round_view_list_24)
                }
                isViewTypeList = !isViewTypeList
            }
            else -> throw IllegalArgumentException()
        }
        return true
    }

    override fun onDestroyView() {
        val viewPager : ViewPager2 = binding.viewPager2Main
        viewPager.unregisterOnPageChangeCallback(callback)
        _binding = null
        super.onDestroyView()
    }
}