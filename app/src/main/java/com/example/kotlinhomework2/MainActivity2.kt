package com.example.kotlinhomework2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val btn_send = findViewById<Button>(R.id.btn_send)
        val ed_drink = findViewById<TextView>(R.id.ed_drink)
        val radioGroup = findViewById<RadioGroup>(R.id.radtioGroup)
        val radioGroup2 = findViewById<RadioGroup>(R.id.radtioGroup2)
        btn_send.setOnClickListener{
            if(ed_drink.length()<1)
                Toast.makeText(this,"請輸入飲料名稱",Toast.LENGTH_SHORT).show()
            else{
                val b=Bundle()
                b.putString("drink",ed_drink.text.toString())
                b.putString("sugar",radioGroup.findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text.toString())
                b.putString("ice",radioGroup2.findViewById<RadioButton>(radioGroup2.checkedRadioButtonId).text.toString())
                setResult(Activity.RESULT_OK, Intent().putExtras(b))
                finish()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}