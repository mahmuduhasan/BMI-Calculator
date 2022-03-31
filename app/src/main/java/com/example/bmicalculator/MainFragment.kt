package com.example.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import java.math.RoundingMode
import java.nio.channels.FileLock
import java.text.DecimalFormat

class MainFragment : Fragment() {

    private lateinit var weightIF : EditText
    private lateinit var heightIF : EditText
    private lateinit var submitBTN : ImageButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        weightIF = view.findViewById(R.id.weightET)
        heightIF = view.findViewById(R.id.heightET)
        submitBTN = view.findViewById(R.id.imageButton)

        submitBTN.setOnClickListener {
            val weightValue = weightIF.text.toString()
            val heightValue = heightIF.text.toString()

            if(weightValue.isEmpty()){
                weightIF.error = "Please enter valid input!"
                return@setOnClickListener
            }

            if(heightValue.isEmpty()){
                heightIF.error = "Please enter valid input!"
                return@setOnClickListener
            }

            val weight = weightValue.toDouble()
            val height = heightValue.toDouble()

            if(weight < 10){
                weightIF.error = "Weight must be more than 10(KG)!"
                return@setOnClickListener
            }
            if (height < 0.5) {
                heightIF.error = "Height must be more than 0.5(M)!"
                return@setOnClickListener
            }

            val BMI : Double = weight/ (height * height)
            val doubleFormatter = DecimalFormat("#.##")
            doubleFormatter.roundingMode = RoundingMode.DOWN
            val roundedBMI = doubleFormatter.format(BMI)

            val bundle = Bundle().apply {
                putString("bmi_value",roundedBMI.toString())
            }

            findNavController().navigate(R.id.action_mainFragment_to_homeFragment, bundle)

        }



    }

}