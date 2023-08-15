package uz.turgunboyevjurabek.viewpagerexperiense.adapter

import android.content.Context
import android.view.LayoutInflater
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import uz.turgunboyevjurabek.viewpagerexperiense.R
import uz.turgunboyevjurabek.viewpagerexperiense.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.viewpagerexperiense.fragment.FirstFragment
import uz.turgunboyevjurabek.viewpagerexperiense.fragment.SecondFragment
import uz.turgunboyevjurabek.viewpagerexperiense.fragment.ThirdFragment

class PagerAdapter(val fm :FragmentManager): FragmentPagerAdapter(fm) {
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