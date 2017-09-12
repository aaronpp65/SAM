package com.creativeclan.test2;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisteratioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeratio);
        final EditText etbuilding=(EditText) findViewById(R.id.etbuilding);
        final EditText etroomno=(EditText) findViewById(R.id.etroomno);
        final EditText etitemcode=(EditText) findViewById(R.id.etitemcode);
        final EditText etName=(EditText) findViewById(R.id.etName);
        final EditText etsectionno=(EditText) findViewById(R.id.etsectionno);
        final EditText etusername=(EditText) findViewById(R.id.etusername);
        final EditText etassetcost=(EditText) findViewById(R.id.etassetcost);
        final EditText etageing=(EditText) findViewById(R.id.etageing);
        final EditText etdateofpurchase=(EditText) findViewById(R.id.etdateofpurchase);
        final EditText etsupplier=(EditText) findViewById(R.id.etsupplier);
        final EditText etid=(EditText) findViewById(R.id.etid);

        final Button etRegister=(Button) findViewById(R.id.etRegister);

        etRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name=etName.getText().toString();
                final String itemcode=etitemcode.getText().toString();
                final String roomno=etroomno.getText().toString();
                final String building=etbuilding.getText().toString();
                final String sectionno=etsectionno.getText().toString();
                final String username=etusername.getText().toString();
                final String assetcost=etassetcost.getText().toString();
                final String ageing=etageing.getText().toString();
                final String dateofpurchase=etdateofpurchase.getText().toString();
                final String supplier=etsupplier.getText().toString();
                final String id=etid.getText().toString();
                //Log.d("Usename",username);
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success=jsonResponse.getBoolean("success");
                            if(success)
                            {
                                Intent intent=new Intent(RegisteratioActivity.this,StockOptions.class);
                                RegisteratioActivity.this.startActivity(intent);
                            }
                            else
                            {
                                AlertDialog.Builder builder =new AlertDialog.Builder(RegisteratioActivity.this);
                                builder.setMessage("Registration failed")
                                        .setNegativeButton("retry",null)
                                        .create()
                                        .show();
                            }
                        }

                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }

                };

                RegisterRequest registerRequest =new RegisterRequest(id,name,itemcode,building,roomno,sectionno,username,assetcost,ageing,dateofpurchase,supplier,responseListener);
                RequestQueue queue= Volley.newRequestQueue(RegisteratioActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}
