package com.shubham.newsapp.Db

import androidx.room.TypeConverter
import com.shubham.newsapp.Models.api.Article
import com.shubham.newsapp.Models.api.Source

class Converter {
    @TypeConverter
    fun fromSource(source: Source): String{
        return source.name
    }
    @TypeConverter
    fun getSource(name : String):Source{
        return Source(name, name)
    }

}