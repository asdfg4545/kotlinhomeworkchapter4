package com.example.kotlinhomework2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(saveInstanceState:Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.activity_main)
        val btn_choice = findViewById<Button>(R.id.btn_choice)

        btn_choice.setOnClickListener{
            startActivityForResult(Intent(this,MainActivity2::class.java),1)

        }

        enableEdgeToEdge()
        intent.putExtra("key",123)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val tv_meal=findViewById<TextView>(R.id.tv_meal)
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let {
            if(requestCode==1&&resultCode==Activity.RESULT_OK)
            tv_meal.text="飲料:${it.getString("drink")}\n\n"+"甜度:${it.getString("sugar")}\n\n"+"冰塊:${it.getString("ice")}"
        }
    }
}