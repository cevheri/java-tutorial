package com.cevher.java.str;
/**
 * Reverse the words in a String using split() method of the String class
 */
public class StringSplit {
    public static void main(String[] args) {
        String str = "Monday Tuesday Wednesday Thursday Friday Saturday Sunday";
        String[] tokens = str.split("\\s");  // white space '\s' as delimiter
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tokens.length; ++i) {
            sb.insert(0, tokens[i]);
            if (i < tokens.length - 1) {
                sb.insert(0, " ");
            }
        }
        String strReverse = sb.toString();
        System.out.println(strReverse);
    }
}