package project.wgtech.limited.main

import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2

class OnPageChangedCallback(private val titles: List<String>, private val toolbar: Toolbar) : ViewPager2.OnPageChangeCallback() {

    override fun onPageScrollStateChanged(state: Int) {
        super.onPageScrollStateChanged(state)
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        super.onPageScrolled(position, positionOffset, positionOffsetPixels)
    }

    override fun onPageSelected(position: Int) {
        toolbar.title = titles[position]
        super.onPageSelected(position)
    }
}