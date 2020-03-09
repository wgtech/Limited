package project.wgtech.limited.item

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.jetbrains.annotations.NotNull

class TabsAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle,
                  @NotNull private var fragments: MutableList<Fragment>) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun createFragment(position: Int): Fragment = fragments[position]
    override fun getItemCount(): Int = fragments.size
}