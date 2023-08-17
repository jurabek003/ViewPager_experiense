package uz.turgunboyevjurabek.viewpagerexperiense.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import uz.turgunboyevjurabek.viewpagerexperiense.R
import uz.turgunboyevjurabek.viewpagerexperiense.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.viewpagerexperiense.databinding.ItemTabBinding
import uz.turgunboyevjurabek.viewpagerexperiense.fragment.FirstFragment
import uz.turgunboyevjurabek.viewpagerexperiense.fragment.SecondFragment
import uz.turgunboyevjurabek.viewpagerexperiense.fragment.ThirdFragment

class PagerAdapter(val fa :FragmentManager ): FragmentStatePagerAdapter(fa) {

//    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        val itemTabBinding=ItemTabBinding.inflate(LayoutInflater.from(container.context),container,false)
//        itemTabBinding.itemTabText.text=list[position]
//        container.addView(itemTabBinding.root)
//        return itemTabBinding.root
//    }
//
//    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//        container.removeView(`object` as View)
//    }


    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0->FirstFragment()
            1->SecondFragment()
            2->ThirdFragment()
            else -> FirstFragment()
        }
    }

}