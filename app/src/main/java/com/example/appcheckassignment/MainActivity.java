package com.example.appcheckassignment;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
  TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    textView = findViewById(R.id.text_view);



    RequestQueue requestQueue = Volley.newRequestQueue(this);
    JsonObjectRequest  jsonObjectRequest = new JsonObjectRequest(
            Request.Method.GET,

                "https://node-fake-api-server.herokuapp.com/",
                null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
              textView.setText(response.toString());

            }
          },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              Toast.makeText(MainActivity.this, "errror", Toast.LENGTH_SHORT).show();

            }
        }
      );
    requestQueue.add(jsonObjectRequest);
  }
}