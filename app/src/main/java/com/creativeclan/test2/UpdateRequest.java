package com.creativeclan.test2;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 19/3/17.
 */

public class UpdateRequest extends StringRequest {
    private  static final String Update_request_url="http://jilujose6.000webhostapp.com/updateData.php"; //check url
    private Map<String, String> params;

    public UpdateRequest(String name,String building, String roomno,Response.Listener<String> listener)
    {
        super(Method.POST,Update_request_url,listener,null);

        params=new HashMap<>();
//        params.put("id",id);
        params.put("name",name);
        //params.put("itemcode",itemcode);
        params.put("roomno",roomno);
        params.put("building",building);
        //params.put("sectionno",sectionno);
        //params.put("username",username);
        //params.put("assetcost",assetcost);
        //params.put("ageing",ageing);
        //params.put("dateofpurchase",dateofpurchase);
        //params.put("supplier",supplier);
Log.d("name",name);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
