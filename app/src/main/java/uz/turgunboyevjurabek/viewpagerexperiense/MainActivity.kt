package uz.turgunboyevjurabek.viewpagerexperiense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import uz.turgunboyevjurabek.viewpagerexperiense.adapter.PagerAdapter
import uz.turgunboyevjurabek.viewpagerexperiense.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.viewpagerexperiense.databinding.ItemTabBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var pagerAdapter: PagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewPager()
    }

    private fun viewPager() {
        val fm=supportFragmentManager
        pagerAdapter=PagerAdapter(fm)
        binding.myViewPager.adapter=pagerAdapter
        binding.myTabLayout.setupWithViewPager(binding.myViewPager)

        val list=ArrayList<String>()
        list.addAll(listOf("Junior","Middle","Senior"))

        val itemTabBinding=ItemTabBinding.inflate(layoutInflater)
        val tabcount=binding.myTabLayout.tabCount
        for (i in 0 until tabcount  ){
            val tab=binding.myTabLayout.getTabAt(i)
            itemTabBinding.itemTabText.text=list[i]
            tab?.text=list[i]
            tab?.customView=itemTabBinding.root
        }
    }
}