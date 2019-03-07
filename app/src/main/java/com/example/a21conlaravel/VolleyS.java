package com.example.a21conlaravel;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyS {

    private static VolleyS vy = null;
    public RequestQueue mRequestQueue;

    private VolleyS(Context context){
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public static VolleyS getInstance(Context context){
        if(vy == null){
            vy = new VolleyS(context);
        }
        return vy;
    }

    public RequestQueue getmRequestQueue(){
        return mRequestQueue;
    }
}
