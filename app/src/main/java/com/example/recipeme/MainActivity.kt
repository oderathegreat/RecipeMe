package com.example.recipeme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException

class MainActivity : AppCompatActivity() {

    private lateinit var search_Btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search_Btn = findViewById(R.id.searchbtn)

        search_Btn.setOnClickListener {
            var intent = Intent(this, RecipeLayout::class.java)
            startActivity(intent)
        }


    }




    }

