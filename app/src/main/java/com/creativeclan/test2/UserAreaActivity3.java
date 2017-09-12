package com.creativeclan.test2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserAreaActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area3);
        final Button etmanual23=(Button) findViewById(R.id.etmanual23);

        etmanual23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Registerintent=new Intent(UserAreaActivity3.this,Update.class);
                UserAreaActivity3.this.startActivity(Registerintent);
            }
        });
    }
}
