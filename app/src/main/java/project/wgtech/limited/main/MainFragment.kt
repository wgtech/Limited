package project.wgtech.limited.main

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.tab_custom_main.view.*
import project.wgtech.limited.R
import project.wgtech.limited.databinding.FragmentMainBinding
import project.wgtech.limited.item.*
import java.lang.IllegalArgumentException

class MainFragment : Fragment(R.layout.fragment_main), Toolbar.OnMenuItemClickListener, TabLayout.OnTabSelectedListener {
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
        //requireActivity().window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
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
        //editText = binding.editTextSearchMain
        //searchTextWatcher = SearchTextWatcher(requireContext(), editText)

        viewPager.adapter = TabsAdapter(childFragmentManager, lifecycle, fragments)
        callback = OnPageChangedCallback(titles, toolbar)
        viewPager.registerOnPageChangeCallback(callback)
        viewPager.isUserInputEnabled = false
        viewPager.currentItem = 0
        //editText.addTextChangedListener(searchTextWatcher)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = titles[position]
            if (position < 3) tab.icon = icons[position]
            tabLayout.isInlineLabel = true
            tabLayout.addOnTabSelectedListener(this)
        }.attach()

        toolbar.setOnMenuItemClickListener(this)

        return binding.root
    }


    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item_search -> {
                /**
                 * TODO
                 *  Set disable to adding fragment to showing results from user search action.
                 *  because the part that displays the data must be performed first.
                 */

                /**

                fragments.add(SearchFragment(items4))
                val title = "Search Keyword"
                titles.add("")
                tabLayout.addTab(
                tabLayout.newTab().setTag(title),
                fragments.size-1, true)
                tabLayout.getTabAt(titles.size-1)?.select()

                viewPager.adapter?.notifyItemInserted(viewPager.adapter!!.itemCount)
                childFragmentManager.executePendingTransactions() // Fix) java.lang.IllegalStateException: Fragment already added

                */
            }

            R.id.item_view_type_change -> {
                if (isViewTypeList) {
                    item.icon = context?.getDrawable(R.drawable.round_view_list_24)
                } else {
                    item.icon = context?.getDrawable(R.drawable.round_view_day_24)
                }
                isViewTypeList = !isViewTypeList
            }
            else -> throw IllegalArgumentException()
        }
        return true
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        viewPager.setCurrentItem(tab!!.position, false)
    }

    override fun onTabReselected(tab: TabLayout.Tab?) { // 다시 누를시 EditText 활성 화면이 나옴. 그 다음에 대한 후속처리 수행해야함.
        if (tab!!.position > 2) {
            val view = LayoutInflater.from(context).inflate(R.layout.tab_custom_main, null)
            view.editText_title_tab.setText(tab.text)
            view.imageButton_cancel_tab.setOnClickListener {
                titles.removeAt(tab.position)
                fragments.removeAt(tab.position)
                tabLayout.removeTab(tab)
            }
            tab.customView = view
        }
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        tab?.customView = null
    }

    override fun onDestroyView() {
        val viewPager : ViewPager2 = binding.viewPager2Main
        viewPager.unregisterOnPageChangeCallback(callback)
        _binding = null
        super.onDestroyView()
    }
}