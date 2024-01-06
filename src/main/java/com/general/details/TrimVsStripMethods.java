package com.general.details;

public class TrimVsStripMethods {


    public static void main(String... args) {

        System.out.println("     ".trim() == ""); //CREATING A NEW STRING()
        System.out.println("     ".strip() == ""); //RETURNING CACHE ""

        String text1 = "  Hello, World!  \n";
        String text2 = "  Hello, World!  ";

        String trimmed1 = text1.strip();   // "Hello, World!"
        String trimmed2 = text2.trim();    // "Hello, World!"

        System.out.println("text1.strip() " + text1.strip());
        System.out.println("text1 trim " + text1.trim());
        System.out.println("text2.trim() " + text2.trim());

        char c = '\u2000'; //not considered whitespace by trim()
        String s = c + "abc" + c;
        System.out.println(Character.isWhitespace(c));
        System.out.println(s.trim());
        System.out.println(s.strip());

    }

}
