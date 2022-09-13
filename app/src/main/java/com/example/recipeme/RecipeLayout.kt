package com.example.recipeme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.recipeme.data.RecipeAdapter
import com.example.recipeme.model.Recipe
import org.json.JSONArray
import org.json.JSONException
import kotlin.math.log

class RecipeLayout : AppCompatActivity() {

    var volleyRequest: RequestQueue? = null
    var recipeList:ArrayList<Recipe>? = null
    var recipeAdapter:RecipeAdapter? =null
    var layoutManager: RecyclerView.LayoutManager? =null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_layout)

        //instantiate our request
        volleyRequest = Volley.newRequestQueue(this)

        //instantiate our recipe list
        recipeList = ArrayList<Recipe>()


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

                       var beertitle = drinksObj.getString("name")
                       var beerdesc = drinksObj.getString("description")
                       var beerthumb = drinksObj.getString("image_url")
                        //Log.d("TAGLINE===>", tagline.toString()) working fine
                        //Construct our recipe object
                        var recipe = Recipe()
                        recipe.title = beertitle
                        recipe.descri = beerdesc
                        recipe.thumbnail = beerthumb

                        recipeList!!.add(recipe)

                        //Instantiate our adapter
                        recipeAdapter = RecipeAdapter(recipeList!!, this)
                        layoutManager = LinearLayoutManager(this)



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