package com.example.recipeme.model

class Recipe() {

    var title:String? = null
    var descri:String? = null
    var thumbnail:String ? = null
    var share:String ? = null

    constructor(title:String, descri:String, thumbnail:String, share:String ) : this() {
        this.title = title
        this.descri = descri
        this.thumbnail = thumbnail
        this.share = share

    }


}
