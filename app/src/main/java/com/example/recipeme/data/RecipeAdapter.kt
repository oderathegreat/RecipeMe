package com.example.recipeme.data

import android.content.Context
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeme.R
import com.example.recipeme.model.Recipe
import com.squareup.picasso.Picasso

class RecipeAdapter(private val list: ArrayList<Recipe>, private val context : Context): RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        //inflate our layout
        val view = LayoutInflater.from(context).inflate(R.layout.list_row, parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //check if its null
        holder.bindViews(list[position])


    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        //fetch all of our views
        var recipetitle = itemView.findViewById<TextView>(R.id.recipe_title)
        var thumbnail = itemView.findViewById<ImageView>(R.id.thumbnailpic)
        var recipeDesc = itemView.findViewById<TextView>(R.id.recipe_desc)
        var shareBtn = itemView.findViewById<Button>(R.id.btn_link)

        fun bindViews(recipe: Recipe) {
            recipetitle.text = recipe.title
            recipeDesc.text = recipe.descri
            shareBtn.setOnClickListener {  }

            //if thumbnail is empty load a default avatar
            if (!TextUtils.isEmpty(recipe.thumbnail)) {
                //load with picasso
                Picasso.get()
                    .load(recipe.thumbnail)
                    .placeholder(android.R.drawable.ic_menu_upload)
                    .error(android.R.drawable.ic_menu_upload)
                    .into(thumbnail)
            } else
            {
                Picasso.get().load(android.R.drawable.ic_menu_upload).into(thumbnail)
            }

        }

    }

}