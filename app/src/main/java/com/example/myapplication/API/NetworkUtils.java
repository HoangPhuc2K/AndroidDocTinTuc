package com.example.myapplication.API;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtils {
    public static String login(String username,String password) {
        Uri builtURI = Uri.parse("http://10.0.2.2:8000/api/Member?").buildUpon()
                .appendQueryParameter("Username",username)
                .appendQueryParameter("Password",password)
                .build();
        Log.d("TEST_LOG",builtURI.toString());
        try {
            URL requestURL = new URL(builtURI.toString());
            return callAPI(requestURL, "POST");
        } catch (MalformedURLException e) {
            return null;
        }
    }
    public static String singUp(String usermember, String password) {
        Uri builtURI = Uri.parse("http://10.0.2.2:8000/api/Member/SingUp?").buildUpon()
                .appendQueryParameter("Usemember",usermember)
                .appendQueryParameter("Password",password)
                .appendQueryParameter("Email","adsd")
                .appendQueryParameter("Fullname",usermember)
                .build();
        Log.d("TEST_SIGUP",builtURI.toString());
        try {
            URL requestURL = new URL(builtURI.toString());
            Log.d("TEST_SINGUP",builtURI.toString());
            return callAPI(requestURL, "POST");
        } catch (MalformedURLException e) {
            return null;
        }
    }
    public static String loadListNew() {
        Uri builtURI = Uri.parse("http://10.0.2.2:8000/api/News").buildUpon()
                .build();
        Log.d("TEST_LOG",builtURI.toString());
        try {
            URL requestURL = new URL(builtURI.toString());
            Log.d("TEST_LOG",requestURL.toString());
            return callAPI(requestURL, "POST");
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public static String callAPI(URL requestURL, String method) {
        HttpURLConnection urlConnection = null;
        String result = "";
        try {
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod(method);
            urlConnection.connect();
            // Get the InputStream.
            InputStream inputStream = urlConnection.getInputStream();
            result = convertISToString(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return result;
    }

    public static String convertISToString(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                builder.append(line + "\n");
                if (builder.length() == 0) {
                    return null;
                }
            }
        } catch (IOException e) {
            return null;
        }
        return builder.toString();
    }

}
