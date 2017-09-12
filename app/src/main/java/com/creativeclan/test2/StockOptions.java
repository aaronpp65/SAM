package com.creativeclan.test2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StockOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_options);
        final Button etstockentry=(Button) findViewById(R.id.etstockentry);
        final Button etstocktracking=(Button) findViewById(R.id.etstocktracking);
        final Button etstockupdation=(Button) findViewById(R.id.etstockupdation);

        etstockentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Registerintent=new Intent(StockOptions.this,UserAreaActivity.class);
                StockOptions.this.startActivity(Registerintent);
            }
        });
        etstocktracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trackintent=new Intent(StockOptions.this,UserAreaActivity2.class);
                StockOptions.this.startActivity(trackintent);
            }
        });
       etstockupdation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updateintent=new Intent(StockOptions.this,UserAreaActivity3.class);
                StockOptions.this.startActivity(updateintent);
            }
        });


    }
}
