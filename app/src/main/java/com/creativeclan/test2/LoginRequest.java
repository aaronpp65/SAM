package com.creativeclan.test2;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 19/3/17.
 */

public class LoginRequest extends StringRequest {
    private  static final String Login_request_url="http://jilujose6.000webhostapp.com/Login.php"; //check url
    private Map<String, String> params;

    public LoginRequest(String username,String password, Response.Listener<String> listener)
    {
        super(Method.POST,Login_request_url,listener,null);
        params=new HashMap<>();
        params.put("username",username);
        params.put("password",password);
    }




    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
