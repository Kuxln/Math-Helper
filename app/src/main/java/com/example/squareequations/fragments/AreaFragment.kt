package com.example.squareequations.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.squareequations.R
import com.example.squareequations.databinding.FragmentAreaBinding
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

class AreaFragment : Fragment(R.layout.fragment_area) {
    private lateinit var binding: FragmentAreaBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAreaBinding.bind(view)
        val figures = arrayListOf(
            "Rectangle",
            "Triangle",
            "Sphere",
            "Trapeze",
            "Circle",
            "Parallelogram",
            "Pyramid",
            "Cone",
            "Cylinder",
            "Rhombus"
        )
        val arrayAdapter = ArrayAdapter(view.context, R.layout.spinner_list_item, figures)
        binding.spinnerArea.adapter = arrayAdapter
        binding.spinnerArea.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view1: View?, position: Int, id: Long
            ) {
                hideViews()
                when (position) {
                    0 -> calculateRectangle()
                    1 -> calculateTriangle(view)
                    2 -> calculateSphere()
                    3 -> calculateTrapeze(view)
                    4 -> calculateCircle(view)
                    5 -> calculateParallelogram()
                    6 -> calculatePyramid()
                    7 -> calculateCone()
                    8 -> calculateCylinder()
                    9 -> calculateRhombus()
                    else -> hideViews()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
    }

    @SuppressLint("SetTextI18n")
    private fun calculateRectangle() {
        binding.formula.text = "S = a*b"
        binding.formula.visibility = View.VISIBLE
        binding.firstTV.text = "Enter 'a':"
        binding.secondTV.text = "Enter 'b':"
        binding.firstTV.visibility = View.VISIBLE
        binding.secondTV.visibility = View.VISIBLE
        binding.firstET.setText("0")
        binding.secondET.setText("0")
        binding.firstET.visibility = View.VISIBLE
        binding.secondET.visibility = View.VISIBLE
        binding.buttonCalculate.visibility = View.VISIBLE

        binding.buttonCalculate.setOnClickListener {
            val a = binding.firstET.text.toString().toDouble()
            val b = binding.secondET.text.toString().toDouble()
            val S = a * b
            binding.result.text = "S = $S"
            binding.result.visibility = View.VISIBLE

        }
    }

    @SuppressLint("SetTextI18n")
    private fun calculateTriangle(view: View) {
        val formulas = arrayListOf(
            "S = 1/2 * a * h",
            "S = sqrt(p * (p−a)*(p−b)*(p−c))"
        )
        val subArrayAdapter = ArrayAdapter(view.context, R.layout.spinner_list_item, formulas)
        binding.subSpinnerArea.adapter = subArrayAdapter
        binding.subSpinnerArea.visibility = View.VISIBLE
        binding.subSpinnerArea.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long
                ) {
                    hideViews()
                    binding.subSpinnerArea.visibility = View.VISIBLE
                    when (position) {
                        0 -> {
                            binding.formula.text = "S = 1/2 * a * h"
                            binding.formula.visibility = View.VISIBLE
                            binding.firstTV.text = "Enter 'a':"
                            binding.firstTV.visibility = View.VISIBLE
                            binding.secondTV.text = "Enter 'h':"
                            binding.secondTV.visibility = View.VISIBLE
                            binding.firstET.setText("0")
                            binding.firstET.visibility = View.VISIBLE
                            binding.secondET.setText("0")
                            binding.secondET.visibility = View.VISIBLE
                            binding.buttonCalculate.visibility = View.VISIBLE

                            binding.buttonCalculate.setOnClickListener {
                                val a = binding.firstET.text.toString().toDouble()
                                val h = binding.secondET.text.toString().toDouble()
                                val S = 0.5 * a * h
                                binding.result.text = "S = $S"
                                binding.result.visibility = View.VISIBLE

                            }
                        }

                        1 -> {
                            binding.formula.text = "S = sqrt(p * (p−a)*(p−b)*(p−c))"
                            binding.formula.visibility = View.VISIBLE
                            binding.firstTV.text = "Enter 'a':"
                            binding.firstTV.visibility = View.VISIBLE
                            binding.secondTV.text = "Enter 'b':"
                            binding.secondTV.visibility = View.VISIBLE
                            binding.thirdTV.text = "Enter 'c':"
                            binding.thirdTV.visibility = View.VISIBLE
                            binding.firstET.setText("0")
                            binding.firstET.visibility = View.VISIBLE
                            binding.secondET.setText("0")
                            binding.secondET.visibility = View.VISIBLE
                            binding.thirdET.setText("0")
                            binding.thirdET.visibility = View.VISIBLE
                            binding.buttonCalculate.visibility = View.VISIBLE

                            binding.buttonCalculate.setOnClickListener {
                                val a = binding.firstET.text.toString().toFloat()
                                val b = binding.secondET.text.toString().toFloat()
                                val c = binding.thirdET.text.toString().toFloat()
                                val p = (a + b + c) / 2
                                val S = sqrt(p * (p - a) * (p - b) * (p - c))
                                binding.result.text = "S = $S"
                                binding.result.visibility = View.VISIBLE
                            }
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
    }

    @SuppressLint("SetTextI18n")
    private fun calculateSphere() {
        binding.formula.text = "S = 4*π*R^2"
        binding.formula.visibility = View.VISIBLE
        binding.firstTV.text = "Enter 'R':"
        binding.firstTV.visibility = View.VISIBLE
        binding.firstET.setText("0")
        binding.firstET.visibility = View.VISIBLE
        binding.buttonCalculate.visibility = View.VISIBLE

        binding.buttonCalculate.setOnClickListener {
            val r = binding.firstET.text.toString().toDouble()
            val S = 4 * Math.PI * r.pow(2)
            binding.result.text = "S = $S"
            binding.result.visibility = View.VISIBLE

        }
    }

    @SuppressLint("SetTextI18n")
    private fun calculateTrapeze(view: View) {
        val formulas = arrayListOf(
            "S = (a+b) / 2 * h", "S = l * h", "S = 1/2 * d1 * d2 * sin (α)"
        )
        val subArrayAdapter = ArrayAdapter(view.context, R.layout.spinner_list_item, formulas)
        binding.subSpinnerArea.adapter = subArrayAdapter
        binding.subSpinnerArea.visibility = View.VISIBLE
        binding.subSpinnerArea.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long
                ) {
                    hideViews()
                    binding.subSpinnerArea.visibility = View.VISIBLE
                    when (position) {
                        0 -> {
                            binding.formula.text = "S = (a+b) / 2 * h"
                            binding.formula.visibility = View.VISIBLE
                            binding.firstTV.text = "Enter 'a':"
                            binding.firstTV.visibility = View.VISIBLE
                            binding.secondTV.text = "Enter 'b':"
                            binding.secondTV.visibility = View.VISIBLE
                            binding.thirdTV.text = "Enter 'h':"
                            binding.thirdTV.visibility = View.VISIBLE
                            binding.firstET.setText("0")
                            binding.firstET.visibility = View.VISIBLE
                            binding.secondET.setText("0")
                            binding.secondET.visibility = View.VISIBLE
                            binding.thirdET.setText("0")
                            binding.thirdET.visibility = View.VISIBLE
                            binding.buttonCalculate.visibility = View.VISIBLE

                            binding.buttonCalculate.setOnClickListener {
                                val a = binding.firstET.text.toString().toDouble()
                                val b = binding.secondET.text.toString().toDouble()
                                val h = binding.thirdET.text.toString().toDouble()
                                val S = ((a + b) / 2) * h
                                binding.result.text = "S = $S"
                                binding.result.visibility = View.VISIBLE

                            }
                        }

                        1 -> {
                            binding.formula.text = "S = l * h"
                            binding.formula.visibility = View.VISIBLE
                            binding.firstTV.text = "Enter 'l':"
                            binding.firstTV.visibility = View.VISIBLE
                            binding.secondTV.text = "Enter 'h':"
                            binding.secondTV.visibility = View.VISIBLE
                            binding.firstET.setText("0")
                            binding.firstET.visibility = View.VISIBLE
                            binding.secondET.setText("0")
                            binding.secondET.visibility = View.VISIBLE
                            binding.buttonCalculate.visibility = View.VISIBLE

                            binding.buttonCalculate.setOnClickListener {
                                val l = binding.firstET.text.toString().toDouble()
                                val h = binding.secondET.text.toString().toDouble()
                                val S = l * h
                                binding.result.text = "S = $S"
                                binding.result.visibility = View.VISIBLE

                            }
                        }

                        2 -> {
                            binding.formula.text = "S = 1/2 * d1 * d2 * sin (α)"
                            binding.formula.visibility = View.VISIBLE
                            binding.firstTV.text = "Enter 'd1':"
                            binding.firstTV.visibility = View.VISIBLE
                            binding.secondTV.text = "Enter 'd2':"
                            binding.secondTV.visibility = View.VISIBLE
                            binding.thirdTV.text = "Enter angle 'α':"
                            binding.thirdTV.visibility = View.VISIBLE
                            binding.firstET.setText("0")
                            binding.firstET.visibility = View.VISIBLE
                            binding.secondET.setText("0")
                            binding.secondET.visibility = View.VISIBLE
                            binding.thirdET.setText("0")
                            binding.thirdET.visibility = View.VISIBLE
                            binding.buttonCalculate.visibility = View.VISIBLE

                            binding.buttonCalculate.setOnClickListener {
                                val d1 = binding.firstET.text.toString().toFloat()
                                val d2 = binding.secondET.text.toString().toFloat()
                                val angle =
                                    (binding.thirdET.text.toString().toFloat()) * Math.PI / 180
                                var S = (0.5 * d1 * d2 * sin(angle)).toFloat()
                                if (S > -0.00001 && S < 0.00001) {
                                    S = 0.0F
                                }
                                binding.result.text = "S = $S"
                                binding.result.visibility = View.VISIBLE
                            }
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
    }

    @SuppressLint("SetTextI18n")
    private fun calculateCircle(view: View) {
        val formulas = arrayListOf(
            "S = π * R^2",
            "S = (π * D^2) / 4"
        )
        val subArrayAdapter = ArrayAdapter(view.context, R.layout.spinner_list_item, formulas)
        binding.subSpinnerArea.adapter = subArrayAdapter
        binding.subSpinnerArea.visibility = View.VISIBLE
        binding.subSpinnerArea.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long
                ) {
                    hideViews()
                    binding.subSpinnerArea.visibility = View.VISIBLE
                    when (position) {
                        0 -> {
                            binding.formula.text = "S = π * R^2"
                            binding.formula.visibility = View.VISIBLE
                            binding.firstTV.text = "Enter 'R':"
                            binding.firstET.setText("0")
                            binding.firstET.visibility = View.VISIBLE
                            binding.buttonCalculate.visibility = View.VISIBLE

                            binding.buttonCalculate.setOnClickListener {
                                val r = binding.firstET.text.toString().toDouble()
                                val S = r.pow(2) * Math.PI
                                binding.result.text = "S = $S"
                                binding.result.visibility = View.VISIBLE

                            }
                        }

                        1 -> {
                            binding.formula.text = "S = (π * D^2) / 4"
                            binding.formula.visibility = View.VISIBLE
                            binding.firstTV.text = "Enter 'D':"
                            binding.firstTV.visibility = View.VISIBLE
                            binding.firstET.setText("0")
                            binding.firstET.visibility = View.VISIBLE
                            binding.buttonCalculate.visibility = View.VISIBLE
                            binding.buttonCalculate.setOnClickListener {
                                val d = binding.firstET.text.toString().toDouble()
                                val S = (Math.PI * d.pow(2)) / 4
                                binding.result.text = "S = $S"
                                binding.result.visibility = View.VISIBLE
                            }
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
    }


    private fun calculateParallelogram() {

    }

    private fun calculatePyramid() {

    }

    private fun calculateCone() {

    }

    private fun calculateCylinder() {

    }

    private fun calculateRhombus() {

    }

    private fun hideViews() {
        binding.firstTV.visibility = View.GONE
        binding.firstET.visibility = View.GONE
        binding.secondTV.visibility = View.GONE
        binding.secondET.visibility = View.GONE
        binding.thirdTV.visibility = View.GONE
        binding.thirdET.visibility = View.GONE
        binding.subSpinnerArea.visibility = View.GONE
        binding.formula.visibility = View.GONE
        binding.result.visibility = View.GONE
        binding.buttonCalculate.visibility = View.GONE
    }
}