package com.cevher.java.util;

import java.util.Locale;
import java.text.NumberFormat;

public class NumberFormatAll {
    public static void main(String[] args) {
        // Print a number using the localized number, integer, currency,
        //  and percent format for each available locale
        Locale[] locales = NumberFormat.getAvailableLocales();
        double myNumber = -1234.56;
        NumberFormat format;

        // General Number format
        System.out.println("General Format:");
        for (Locale locale : locales) {
            if (locale.getCountry().length() == 0) continue;  // Skip language-only locales
            format = NumberFormat.getInstance(locale);
            System.out.printf("%40s -> %s%n", locale.getDisplayName(), format.format(myNumber));
        }

        // Integer format
        System.out.println("Integer Format:");
        for (Locale locale : locales) {
            if (locale.getCountry().length() == 0) continue;  // Skip language-only locales
            format = NumberFormat.getIntegerInstance(locale);
            System.out.printf("%40s -> %s%n", locale.getDisplayName(), format.format(myNumber));
        }

        // Currency format
        System.out.println("Currency Format:");
        for (Locale locale : locales) {
            if (locale.getCountry().length() == 0) continue;  // Skip language-only locales
            format = NumberFormat.getCurrencyInstance(locale);
            System.out.printf("%40s -> %s%n", locale.getDisplayName(), format.format(myNumber));
        }

        // Percent format
        System.out.println("Percent Format:");
        for (Locale locale : locales) {
            if (locale.getCountry().length() == 0) continue;  // Skip language-only locales
            format = NumberFormat.getPercentInstance(locale);
            System.out.printf("%40s -> %s%n", locale.getDisplayName(), format.format(myNumber));
        }
    }
}
// General Format:
//                         Arabic (Jordan) -> ؜١٬٢٣٤٫٥٦
//                      Amharic (Ethiopia) -> -1,234.56
//                        French (Algeria) -> -1 234,56
//                     Tigrinya (Ethiopia) -> -1,234.56
//                         Tibetan (China) -> -1,234.56
//                       Quechua (Ecuador) -> -1,234.56
//                       Tamil (Singapore) -> -1,234.56
//                          English (Niue) -> -1,234.56
//                    English (Montserrat) -> -1,234.56
//         Chinese (Simplified, Singapore) -> -1,234.56
//                      English (Guernsey) -> -1,234.56
//                       English (Jamaica) -> -1,234.56
//                        Swedish (Sweden) -> −1 234,56
//                    Serbian (Montenegro) -> -1.234,56
//                       Spanish (Bolivia) -> -1.234,56
// ...
// ..
// .