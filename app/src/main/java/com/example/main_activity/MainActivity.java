package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<Model> ar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url="https://project10.erstechno.online/api.php?education_list=1&groups=Nursing";
        t1=findViewById(R.id.t1);

        ar=new ArrayList<>();

        recyclerView=findViewById(R.id.R1);

        LinearLayoutManager linearlayout=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearlayout);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                            try {
                                Toast.makeText(MainActivity.this, response+"", Toast.LENGTH_SHORT).show();
                                JSONArray array = response.getJSONArray("EBOOK_APP");


                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject jsonObject = array.getJSONObject(i);
                                    Model jsonModel = new Model();

                                    jsonModel.setEdu_id(jsonObject.getString("edu_id"));
                                    ar.add(jsonModel);
                                }

                                adapter = new Adapter(MainActivity.this, ar);
                                recyclerView.setAdapter(adapter);
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(MainActivity.this, "Catch", Toast.LENGTH_SHORT).show();
                            }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(jsonObjectRequest);

    }
}