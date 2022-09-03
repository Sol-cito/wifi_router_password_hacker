package com.hacker;

import java.util.ArrayList;

public class PasswordMakser {
    public String[] createPasswords(char[] eachLetterArr) {
        String[] resultArr = new String[60466176];
        ArrayList<String> aList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            aList.add("" + eachLetterArr[i]);
        }
        for (int i = 0 + 65; i < 26 + 65; i++) {
            aList.add("" + eachLetterArr[i - 65 + 10]);
        }
        int cnt = 0;
        int idx = 0;
        while (cnt < 4) {
            ArrayList<String> nList = new ArrayList<>();
            for (char c : eachLetterArr) {
                for (String s : aList) {
                    String target = new StringBuilder().append(c).append(s).toString();
                    if (cnt == 3) {
                        resultArr[idx] = target;
                        idx++;
                    } else {
                        nList.add(target);
                    }
                }
            }
            aList = nList;
            cnt++;
        }
        return resultArr;
    }
}
