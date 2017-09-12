package com.creativeclan.test2;



import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.BreakIterator;

public class Update extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextId;
    private Button buttonGet,etRegister;
    private EditText etName,etroomno,etbuilding,etsectionno,etusername,etageing,etdateofpurchase;

    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        final Button etupdate=(Button) findViewById(R.id.etupdate);

        editTextId = (EditText) findViewById(R.id.editTextId);
        buttonGet = (Button) findViewById(R.id.buttonGet);
        etRegister = (Button) findViewById(R.id.etRegister);

        etName = (EditText) findViewById(R.id.etName);
        etroomno = (EditText) findViewById(R.id.etroomno);
        etbuilding = (EditText) findViewById(R.id.etbuilding);
        etsectionno = (EditText) findViewById(R.id.etsectionno);
        etusername = (EditText) findViewById(R.id.etusername);
        etageing = (EditText) findViewById(R.id.etageing);
        etdateofpurchase = (EditText) findViewById(R.id.etdateofpurchase);



        buttonGet.setOnClickListener(this);

        etupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name=etName.getText().toString();
                //final String itemcode=etitemcode.getText().toString();
                final String roomno=etroomno.getText().toString();
                final String building=etbuilding.getText().toString();
                //final String sectionno=etsectionno.getText().toString();
                //final String username=etusername.getText().toString();
                //final String assetcost=etassetcost.getText().toString();
                //final String ageing=etageing.getText().toString();
                //final String dateofpurchase=etdateofpurchase.getText().toString();
                //final String supplier=etsupplier.getText().toString();
                //inal String id=etid.getText().toString();
                //Log.d("Usename",username);
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success=jsonResponse.getBoolean("success");
                            if(success)
                            {
                                Intent intent=new Intent(Update.this,StockOptions.class);
                                Update.this.startActivity(intent);
                            }
                            else
                            {
                                AlertDialog.Builder builder =new AlertDialog.Builder(Update.this);
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

                UpdateRequest updateRequest =new UpdateRequest(name,building,roomno,responseListener);
                RequestQueue queue= Volley.newRequestQueue(Update.this);
                queue.add(updateRequest);
            }
        });

    }

    private void getData() {
        String id = editTextId.getText().toString().trim();
        if (id.equals("")) {
            Toast.makeText(this, "Please enter an id", Toast.LENGTH_LONG).show();
            return;
        }
        loading = ProgressDialog.show(this,"Please wait...","Fetching...",false,false);

        String url = Config.DATA_URL+editTextId.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Update.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String response){
        String name="";
        String address="";
        String vc = "";
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            name = collegeData.getString(Config.KEY_NAME);
            address = collegeData.getString(Config.KEY_ADDRESS);
            vc = collegeData.getString(Config.KEY_VC);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        etName.setText(name);
        etroomno.setText(address);
        etbuilding.setText(vc);






    }

    @Override
    public void onClick(View v) {
        getData();
    }
}