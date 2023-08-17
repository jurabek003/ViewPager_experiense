package uz.turgunboyevjurabek.viewpagerexperiense

import android.annotation.SuppressLint
import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.fragment.app.FragmentManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import uz.turgunboyevjurabek.viewpagerexperiense.adapter.PagerAdapter
import uz.turgunboyevjurabek.viewpagerexperiense.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.viewpagerexperiense.databinding.ItemTabBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var pagerAdapter: PagerAdapter
    private val tabBindings = ArrayList<ItemTabBinding>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewPager()
    }

    private fun viewPager() {

        val list= ArrayList<String>()
        list.addAll(listOf("Junior","Middle","Senior"))
        pagerAdapter=PagerAdapter(supportFragmentManager)
        binding.myViewPager.adapter=pagerAdapter
        binding.myTabLayout.setupWithViewPager(binding.myViewPager)

        val tabCount = binding.myTabLayout.tabCount
        val tabItemBinding = ItemTabBinding.inflate(layoutInflater)



       binding.myTabLayout.addOnTabSelectedListener(object :OnTabSelectedListener{
            @SuppressLint("ResourceAsColor")
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val position = tab?.position ?: 0
                val tabBinding = tabBindings[position]
                tabBinding.itemTabText.text = list[position]
                tabBinding.itemTabText.setTextColor(R.color.sariq)
                tab?.text = tabBinding.itemTabText.text.toString()
                tab?.setCustomView(tabBinding.root)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val position = tab?.position ?: 0
        val tabBinding = tabBindings[position]
        tabBinding.itemTabText.text = list[position]
        tab?.text = tabBinding.itemTabText.text.toString()
        tab?.setCustomView(tabBinding.root)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        for (i in 0 until tabCount) {
            //   val tabItemBinding = ItemTabBinding.inflate(layoutInflater)
            val tab = binding.myTabLayout.getTabAt(i)
            tabItemBinding.itemTabText.text = list[i]
            tab?.customView = tabItemBinding.root
            tabBindings.add(tabItemBinding)
        }


    }
}