package com.example.a21conlaravel;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    ImageView img1, img2, img3, img4;
    int sumador;
    TextView sumar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sumar = findViewById(R.id.suma);
        img1 = findViewById(R.id.imagen1);
    }

    public void solicitud(View view) {

        JsonObjectRequest js = new JsonObjectRequest(Request.Method.GET, "http://nuevo.rnrsiilge-org.mx/baraja/numero",
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)  {
                try {
                    Toast.makeText(MainActivity.this, response.getString("numero"), Toast.LENGTH_SHORT).show();
                    int numero = response.getInt("numero");
                    sumador+=numero;
                    Toast.makeText(MainActivity.this, String.valueOf(sumador), Toast.LENGTH_SHORT).show();


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleyS.getInstance(getApplicationContext()).getmRequestQueue().add(js);

    }
}
