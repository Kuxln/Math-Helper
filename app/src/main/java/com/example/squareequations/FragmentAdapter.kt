package com.example.squareequations

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.squareequations.fragments.AreaFragment
import com.example.squareequations.fragments.SquareEquationFragment
import com.example.squareequations.fragments.VolumeFragment

class FragmentAdapter(mainActivity: MainActivity) : FragmentStateAdapter(mainActivity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SquareEquationFragment()
            1 -> AreaFragment()
            2 -> VolumeFragment()

            else -> SquareEquationFragment()
        }
    }
}