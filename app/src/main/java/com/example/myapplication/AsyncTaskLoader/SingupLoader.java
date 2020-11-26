package com.example.myapplication.AsyncTaskLoader;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.example.myapplication.API.NetworkUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class SingupLoader extends AsyncTaskLoader<String> {
    private String UserName;
    private String PassWord;
    public SingupLoader(@NonNull Context context,String username,String password) {
        super(context);
        this.UserName = username;
        this.PassWord = password;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        String result = null;
        try {
            JSONObject jsonObject = new JSONObject(NetworkUtils.singUp(UserName,PassWord));
            result = jsonObject.getString("Singup");
            Log.d("TEST_SINGUP",result);
            return result;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
