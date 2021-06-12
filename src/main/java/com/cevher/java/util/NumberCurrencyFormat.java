package com.cevher.java.util;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberCurrencyFormat {

    //    public static final NumberFormat getInstance();                // Returns a general-purpose number format
    //    public static final NumberFormat getInstance(Locale l);
    //    public static final NumberFormat getNumberInstance();          // Returns a general-purpose number format
    //    public static final NumberFormat getNumberInstance(Locale l);
    //    public static final NumberFormat getIntegerInstance();         // Returns a integer number format
    //    public static final NumberFormat getIntegerInstance(Locale l);
    //    public static final NumberFormat getCurrencyInstance();        // Returns a currency number format
    //    public static final NumberFormat getCurrencyInstance(Locale l);
    //    public static final NumberFormat getPercentInstance();         // Returns a percent number format
    //    public static final NumberFormat getPercentInstance(Locale l);
    //
    public static void main(String[] args) {
        Locale[] locales = {Locale.US, Locale.FRANCE, Locale.JAPAN};

        for (Locale loc : locales) {
            NumberFormat formatter = NumberFormat.getInstance(loc);
            String formattedNumber = formatter.format(123456789.12345);
            System.out.format("%15s: %s\n", loc.getDisplayCountry(), formattedNumber);
        }

        for (Locale loc : locales) {
            NumberFormat formatter = NumberFormat.getCurrencyInstance(loc);
            String formattedNumber = formatter.format(123456789.12345);
            System.out.format("%15s: %s\n", loc.getDisplayCountry(), formattedNumber);
        }

    }
}
//  United States: 123,456,789.123
//         France: 123 456 789,123
//          Japan: 123,456,789.123
//  United States: $123,456,789.12
//         France: 123 456 789,12 €
//          Japan: ￥123,456,789