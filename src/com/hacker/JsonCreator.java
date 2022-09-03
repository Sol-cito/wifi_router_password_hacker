package com.hacker;

import org.json.simple.JSONObject;

public class JsonCreator {
    public JSONObject createJson(String password) {
        JSONObject json = new JSONObject();
        json.put("challenge", "");
        json.put("username", "admin");
        json.put("password", password + "_admin");
        json.put("cap_user", "flnki");
        json.put("save", "로그인");
        json.put("submit-url", "/admin/login.asp");
        return json;
    }
}
