package sakshi.com.practice_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


        Button next, info;
           TextView name, email, mobile;
        String json_url="http://192.168.1.107/getinfo.php";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            next = (Button) findViewById(R.id.bt_next);
            info = (Button) findViewById(R.id.bt_info);
            name = (TextView) findViewById(R.id.tv_name);
            email = (TextView) findViewById(R.id.tv_mail);
            mobile = (TextView) findViewById(R.id.tv_mobile);


            bt_info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, json_url, null,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        tv_name.setText(response.getString("Name"));
                                        tv_mail.setText(response.getString("Email"));
                                        tv_mobile.setText(response.getString("Mobile"));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this, "Somethings wrong", Toast.LENGTH_SHORT).show();
                            error.printStackTrace();
                        }
                    });
                    MySingleton.getInstance(MainActivity.this).addToRequestque(jsonObjectRequest);
                }
            });

        }}