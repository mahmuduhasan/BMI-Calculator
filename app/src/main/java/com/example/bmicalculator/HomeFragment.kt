package com.example.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class HomeFragment : Fragment() {

    private lateinit var bmiShow : TextView
    private lateinit var underOver : TextView
    private lateinit var bmiThin : ImageView
    private lateinit var bmiHealthy : ImageView
    private lateinit var bmiFat : ImageView
    private lateinit var bmiOver : ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bmiShow = view.findViewById(R.id.result)
        underOver = view.findViewById(R.id.showUnderOver)
        bmiThin = view.findViewById(R.id.bmiThin)
        bmiHealthy = view.findViewById(R.id.bmiHealthy)
        bmiFat = view.findViewById(R.id.bmiFat)
        bmiOver = view.findViewById(R.id.bmiOver)

        val bundle = arguments

        val bmi = bundle?.getString("bmi_value")

        val checkBMI = bmi.toString().toDouble()
        if(checkBMI <= 18.5 ){
            underOver.text = "Underweight"
            bmiThin.visibility = View.VISIBLE
        }else if(checkBMI >18.5 && checkBMI <= 23 ){
            underOver.text = "Healthy"
            bmiHealthy.visibility = View.VISIBLE
        } else if(checkBMI >23 && checkBMI <= 27 ){
            underOver.text = "Overweight"
            bmiFat.visibility = View.VISIBLE
        }else if(checkBMI > 27){
            underOver.text = "Obese"
            bmiOver.visibility = View.VISIBLE
        }
        bmiShow.text = "Your BMI result is: $bmi"
    }

}