package com.example.squareequations.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnApplyWindowInsetsListener
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import android.view.WindowInsets
import androidx.fragment.app.Fragment
import com.example.squareequations.R
import com.example.squareequations.databinding.FragmentMainBinding
import kotlin.math.pow
import kotlin.math.sqrt


class SquareEquationFragment : Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentMainBinding.bind(view)

        binding.a.setText("1.0")
        binding.b.setText("1.0")
        binding.c.setText("1.0")

        binding.resultX1.visibility = View.INVISIBLE
        binding.resultX2.visibility = View.GONE
        binding.discriminant.visibility = View.INVISIBLE

        binding.buttonCalculate.setOnClickListener { calculate()}
    }

    @SuppressLint("SetTextI18n")
    private fun calculate() {
        binding.resultX1.visibility = View.INVISIBLE
        binding.resultX2.visibility = View.GONE
        binding.discriminant.visibility = View.INVISIBLE
        val a =  binding.a.text.toString().toDouble()
        Log.d("tag", a.toString())
        val b = binding.b.text.toString().toDouble()
        Log.d("tag", b.toString())
        val c = binding.c.text.toString().toDouble()
        Log.d("tag", c.toString())

        val D = b.pow(2) - 4*a*c
        Log.d("tag", D.toString())
        binding.discriminant.text = "D = $D"
        if (D > -0.0001 && D < 0.0001) {
            val x = (-b) / (2*a)
            binding.resultX1.text = "x = $x"
            binding.resultX1.visibility = View.VISIBLE
        } else if (D > 0) {
            val x1 = (-b - sqrt(D)) / (2*a)
            val x2 = (-b + sqrt(D)) / (2*a)
            binding.resultX1.text = "x1 = $x1"
            binding.resultX2.text = "x2 = $x2"
            binding.resultX1.visibility = View.VISIBLE
            binding.resultX2.visibility = View.VISIBLE
        } else {
            binding.resultX1.text = "the equation has no roots"
            binding.resultX1.visibility = View.VISIBLE
        }
        binding.discriminant.visibility = View.VISIBLE

    }

}
