package com.example.squareequations.core

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.squareequations.activities.MainActivity
import com.example.squareequations.fragments.AreaFragment
import com.example.squareequations.fragments.SquareEquationFragment
import com.example.squareequations.fragments.VolumeFragment

class FragmentAdapter(
    mainActivity: MainActivity,
    private val preferredFragments: IntArray
) : FragmentStateAdapter(mainActivity) {
    override fun getItemCount(): Int {
        return preferredFragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (preferredFragments[position]) {
            0 -> SquareEquationFragment()
            1 -> AreaFragment()
            2 -> VolumeFragment()
            else -> SquareEquationFragment()
        }
    }
}
