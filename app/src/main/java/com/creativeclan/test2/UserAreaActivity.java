package com.creativeclan.test2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        final Button etmanual=(Button) findViewById(R.id.etmanual);
        final Button button23=(Button) findViewById(R.id.button23);
        final Button etqr=(Button) findViewById(R.id.etqr);
        final EditText etUsername=(EditText) findViewById(R.id.etUsername);
        etmanual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Registerintent=new Intent(UserAreaActivity.this,RegisteratioActivity.class);
                UserAreaActivity.this.startActivity(Registerintent);
            }
        });
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UserAreaActivity.this,Serial.class);
                UserAreaActivity.this.startActivity(intent);
            }
        });
        etqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentqr=new Intent(UserAreaActivity.this,DecoderActivity.class);
                UserAreaActivity.this.startActivity(intentqr);
            }
        });


        Intent intent=getIntent();
        String username=intent.getStringExtra("username");

        etUsername.setText(username);

    }
}
