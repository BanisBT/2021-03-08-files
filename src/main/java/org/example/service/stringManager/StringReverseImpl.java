package org.example.service.stringManager;

public class StringReverseImpl implements StringReverse{
    @Override
    public String stringReverse(String text) {
        String textReverse = "";
        char[] textChar = text.toCharArray();
        for (int i = text.length() - 1; i >= 0; i--){
            textReverse += textChar[i];
        }
        return textReverse;
    }
}
