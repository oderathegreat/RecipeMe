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
import kotlin.math.log

class RecipeLayout : AppCompatActivity() {

    var volleyRequest: RequestQueue? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_layout)

        //instantiate our request
        volleyRequest = Volley.newRequestQueue(this)

        val url = "https://api.punkapi.com/v2/beers"
        fetchRecipe(url)


    }

    //fetch recipe data
    fun fetchRecipe(url:String) {
        val arrayReq = JsonArrayRequest(
            Request.Method.GET, url, null,
            {
                    response : JSONArray ->
                try {
                    Log.d("Response", response.toString())

                    //perform a loop to get items
                    for (i in 0 until response.length()-1) {
                        var drinksObj = response.getJSONObject(i)

                       var tagline = drinksObj.getString("tagline")
                        Log.d("TAGLINE===>", tagline.toString())
                    }




                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }, {
                try {

                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            })
        volleyRequest!!.add(arrayReq)


    }
}