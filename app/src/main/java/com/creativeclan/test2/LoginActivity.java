package com.creativeclan.test2;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etPassword=(EditText) findViewById(R.id.etPassword);
        final EditText etUsername=(EditText) findViewById(R.id.etUsername);

        final Button etLogin=(Button) findViewById(R.id.etLogin);
        //final TextView RegisterLink=(TextView) findViewById(R.id.RegisterLink);

        /*RegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Registerintent=new Intent(LoginActivity.this,RegisteratioActivity.class);
                LoginActivity.this.startActivity(Registerintent);
            }
        });*/
    etLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final String username=etUsername.getText().toString();
            final String password=etPassword.getText().toString();
            Response.Listener<String> responselistener= new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jasonResponse=new JSONObject(response);
                        boolean success=jasonResponse.getBoolean("success");
                        if(success){
                            String username=jasonResponse.getString("username");
                            Intent intent=new Intent(LoginActivity.this,StockOptions.class);
                            intent.putExtra("username",username);
                            LoginActivity.this.startActivity(intent);
                        }
                        else{
                            AlertDialog.Builder builder =new AlertDialog.Builder(LoginActivity.this);
                            builder.setMessage("Login failed")
                                    .setNegativeButton("retry",null)
                                    .create()
                                    .show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };
            LoginRequest loginRequest = new LoginRequest(username,password,responselistener);
            RequestQueue queue= Volley.newRequestQueue(LoginActivity.this);
            queue.add(loginRequest);
        }
    });
    }

}
