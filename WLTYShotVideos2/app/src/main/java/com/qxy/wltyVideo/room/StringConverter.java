package com.qxy.wltyVideo.room;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import java.lang.reflect.Type;

public class StringConverter {
    @TypeConverter
    public String objectToString(List<String> list) {
        return new Gson().toJson(list);
    }

    @TypeConverter
    public List<String> stringToObject(String json) {
        Type listType = new TypeToken<List<String>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }
}
