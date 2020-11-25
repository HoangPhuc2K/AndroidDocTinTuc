package com.example.myapplication.AsyncTaskLoader;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.loader.content.AsyncTaskLoader;

import com.example.myapplication.API.NetworkUtils;
import com.example.myapplication.data.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class UserSingup extends AsyncTaskLoader<String> {
    private String UserName;
    private String Password;


    public UserSingup(@NonNull Context context, String username, String password) {
        super(context);
        UserName = username;
        Password = password;
    }

    @Nullable
    @Override
    public String loadInBackground() {
       String result = null;
        try {
            JSONObject jsonObject = new JSONObject(NetworkUtils.singUp(UserName,Password));
            JSONObject jsonItem = jsonObject.getJSONObject("Sigup");
            Log.d("TEST_LOG",jsonItem.toString());
            return result;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
