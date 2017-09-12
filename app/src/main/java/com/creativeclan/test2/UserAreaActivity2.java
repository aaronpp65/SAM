package com.creativeclan.test2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserAreaActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area2);
        final Button etmanual2=(Button) findViewById(R.id.etmanual2);

        etmanual2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Registerintent=new Intent(UserAreaActivity2.this,GetData.class);
                UserAreaActivity2.this.startActivity(Registerintent);
            }
        });
    }
}
