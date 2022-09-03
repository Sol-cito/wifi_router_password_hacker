package com.hacker;

import org.json.simple.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class HttpRequester {
    public void requestPost(String url, JSONObject json) throws Exception{
        String jsonBody = json.toJSONString();
        System.out.println(jsonBody);

        Connection.Response response = Jsoup.connect(url).method(Connection.Method.POST).requestBody(jsonBody).execute();
    }
}
