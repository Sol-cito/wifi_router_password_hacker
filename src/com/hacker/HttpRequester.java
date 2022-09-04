package com.hacker;

import org.json.simple.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HttpRequester {
    public void requestPost(String url, String password) throws Exception {
        Document d = Jsoup.connect(url)
                .data("challenge", "")
                .data("username", "admin")
                .data("password", new StringBuilder().append(password).append("_admin").toString())
                .data("cap_user", "aaa")
                .data("save", "로그인")
                .data("submit-url", "/admin/login.asp")
                .post();
    }
}
