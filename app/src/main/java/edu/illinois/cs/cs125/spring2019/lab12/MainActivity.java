package edu.illinois.cs.cs125.spring2019.lab12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;


import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.toolbox.Volley;

/**
 * Main class for our UI design lab.
 */
public final class MainActivity extends AppCompatActivity {
    /**
     * text.
     */
    private TextView text1;
    /**
     * text.
     */
    private TextView text2;
    /**
     * text.
     */
    private TextView text3;
    /**
     * text.
     */
    private TextView text4;
    /**
     * text.
     */
    private TextView text5;
    /**
     * text.
     */
    private TextView text6;
    /**
     * text.
     */
    private TextView text7;
    /**
     * text.
     */
    private TextView text8;
    /**
     * text.
     */
    private TextView text99;
    /**
     * text.
     */
    private RequestQueue mQueue;
    /**
     * @param savedInstanceState unused
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.textView5);
        text2 = findViewById(R.id.textView8);
        text3 = findViewById(R.id.textView11);
        text4 = findViewById(R.id.textView14);
        text5 = findViewById(R.id.textView17);
        text6 = findViewById(R.id.textView20);
        text7 = findViewById(R.id.textView23);
        text8 = findViewById(R.id.textView26);
        text99 = findViewById(R.id.textView99);
        Button click = findViewById(R.id.button);
        mQueue = Volley.newRequestQueue(this);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonParse();
            }
        });
    }
    private void jsonParse() {

        String url = "http://data.fixer.io/api/latest?access_key=4d9839a578aed279092066bcb8addd72";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jr = response.getJSONObject("rates");
                            Double a1 = jr.getDouble("AUD");
                            Double a2 = jr.getDouble("CAD");
                            Double a3 = jr.getDouble("CNY");
                            Double a4 = jr.getDouble("EUR");
                            Double a5 = jr.getDouble("GBP");
                            Double a6 = jr.getDouble("HKD");
                            Double a7 = jr.getDouble("JPY");
                            Double a8 = jr.getDouble("USD");
                            int a99 = response.getInt("timestamp");
                            text1.setText(String.valueOf(a1));
                            text2.setText(String.valueOf(a2));
                            text3.setText(String.valueOf(a3));
                            text4.setText(String.valueOf(a4));
                            text5.setText(String.valueOf(a5));
                            text6.setText(String.valueOf(a6));
                            text7.setText(String.valueOf(a7));
                            text8.setText(String.valueOf(a8));

                            text99.append(String.valueOf(a99));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
            public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        mQueue.add(request);
    }
}
