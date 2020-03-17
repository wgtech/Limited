package project.wgtech.limited.main

import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.tab_custom_main.view.*
import project.wgtech.limited.R

class OnTabSelectedCallback(private val context: Context, @NonNull private val viewPager: ViewPager2) : TabLayout.OnTabSelectedListener {

    override fun onTabSelected(tab: TabLayout.Tab?) {
        viewPager.setCurrentItem(tab!!.position, false)
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
        if (tab!!.position > 2) {
            Toast.makeText(context, "tab: " + tab.text, Toast.LENGTH_SHORT).show()
            val view = LayoutInflater.from(context).inflate(R.layout.tab_custom_main, null)
            view.editText_title_tab.setText(tab.text)
            tab.customView = view
        }
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        if (tab!!.position > 2) {
            tab.customView = null
        }
    }
}