package com.cevher.java;


/**
 * // Length
 * int length()       // returns the length of the String
 * boolean isEmpty()  // same as str.length() == 0
 * boolean isBlank()  // contains only white spaces (Unicode aware) (JDK 11)
 * <p>
 * // Comparison
 * boolean equals(String another) // CANNOT use '==' or '!=' to compare two Strings in Java
 * boolean equalsIgnoreCase(String another)
 * int compareTo(String another)  // return 0 if this string is the same as another;
 * // <0 if lexicographically less than another; or >0
 * int compareToIgnoreCase(String another)
 * boolean startsWith(String another)
 * boolean startsWith(String another, int fromIdx)  // search begins at fromIdx
 * boolean endsWith(String another)
 * <p>
 * // Searching: index from 0 to str.length()-1
 * int indexOf(String key)
 * int indexOf(String key, int fromIdx)
 * int indexOf(int char)
 * int indexOf(int char, int fromIdx)      // search forward starting at fromIdx
 * int lastIndexOf(String key)
 * int lastIndexOf(String key, int fromIdx)  // search backward starting at fromIdx
 * int lastIndexOf(int char)
 * int lastIndexOf(int char, int fromIdx)
 * <p>
 * // Extracting a char or substring, include fromIdx but exclude toIdx
 * char charAt(int idx)
 * String substring(int fromIdx)
 * String substring(int fromIdx, int toIdx)
 * <p>
 * // Creating a new String or char[] from the original - Strings are immutable
 * String toLowerCase()
 * String toUpperCase()
 * String concat(String another)  // same as str+another
 * String trim()          // creates a new String removing white spaces from front and back
 * String strip()         // strips the leading and trailing white spaces (Unicode aware) (JDK 11)
 * String stripLeading()     // (JDK 11)
 * String stripTrailing()    // (JDK 11)
 * String repeat(int count)  // (JDK 11)
 * String indent(int n)  // adjusts the indentation by n (JDK 12)
 * char[] toCharArray()                        // create a char[] from this string
 * void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)  // copy into dst char[]
 * <p>
 * // Working with CharSequence (super-interface of String, StringBuffer, StringBuilder)
 * boolean contains(CharSequence cs)       // (JDK 5)
 * boolean contentEquals(CharSequence cs)  // (JDK 5)
 * boolean contentEquals(StringBuffer sb)  // (JDK 4)
 * static String join(CharSequence delimiter, CharSequence... elements)  // (JDK 8)
 * static String join(CharSequence delimiter, Iterable<CharSequence> elements)  // (JDK 8)
 * <p>
 * // Text Processing and Regular Expression (JDK 4)
 * boolean matches(String regex)
 * String replace(char old, char new)
 * String replace(CharSequence target, CharSequence replacement)  // (JDK 4)
 * String replaceAll(String regex, String replacement)
 * String replaceFirst(String regex, String replacement)
 * String[] split(String regex)  // Split the String using regex as delimiter, return a String array
 * String[] split(String regex, int count)  // for count times only
 * <p>
 * //static methods
 * // Converting primitives to String
 * static String valueOf(type arg)  // type can be primitives or char[]
 * // Formatting using format specifiers
 * static String format(String formattingString,Object...args)  // same as printf()
 * <p>
 * Stream and Functional Programming
 * Stream<String> lines()  // returns a stream of lines (JDK 11)
 * IntStream chars()       // returns a IntStream of characters (JDK 9)
 * IntStream codePoints()
 * R transform(Function<String, R> f)  // transforms from String to type R (JDK 12)
 */
public class JavaString {

    public static void main(String[] args) {
        String s1 = "Hello";                    // String literal - store in the common pool
        String s2 = "Hello";                    // String literal - store in the common pool
        String s3 = s1;                         // same reference - store in the common pool
        String s4 = new String("Hello"); // String object - store in the Heap
        String s5 = new String("Hello"); // String object - store in the Heap

        System.out.println(s1 == s1);          // true, same pointer
        System.out.println(s1 == s2);           // true, s1 and s1 share storage in common pool
        System.out.println(s1 == s3);           // true, s3 is assigned same pointer as s1
        System.out.println(s1.equals(s3));      // true, same contents
        System.out.println(s1 == s4);           // false, different pointers
        System.out.println(s1.equals(s4));      // true, same contents
        System.out.println(s4 == s5);           // false, different pointers in heap
        System.out.println(s4.equals(s5));      // true, same contents

    }
}
