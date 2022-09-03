package com.hacker;

public class EachLetterCreator {
    public char[] createEachLetter() {
        char[] eachLetterArr = new char[36];
        for (int i = 0; i < 10; i++) {
            eachLetterArr[i] = Integer.toString(i).charAt(0);
        }
        for (int i = 0 + 65; i < 26 + 65; i++) {
            eachLetterArr[i - 65 + 10] = (char) i;
        }
        return eachLetterArr;
    }
}
