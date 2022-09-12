package com.example.recipeme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        var volleyRequest:RequestQueue? = null

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //instantiate our request
        volleyRequest = Volley.newRequestQueue(this)

    }

    //fetch recipe data
    fun fetchRecipe(url:String) {
        val arrayReq = JsonArrayRequest(Request.Method.GET, url, null,
            {
                response : JSONArray ->
                try {
                    Log.d("Response", response.toString())


                } catch (e: JSONException) {
                  e.printStackTrace()
                }
            }, {
                 try {

                 } catch (e:JSONException) {
                     e.printStackTrace()
                 }
            }

            )
    }
}