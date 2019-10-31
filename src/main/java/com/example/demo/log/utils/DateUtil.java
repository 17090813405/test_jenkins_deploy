package com.example.demo.log.utils;

/**
 * @author daizhichao
 * @date 2018/12/18
 */
public class DateUtil {

    public static final String FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {
        System.out.println(formatDate("17/Dec/2018:17:48:17"));
    }

    public static String formatDate(String dateStr) {
        String[] aStrings = dateStr.replace("[", "").split("/");
        if (aStrings[1].equals("Jan")) {
            aStrings[1] = "01";
        }
        if (aStrings[1].equals("Feb")) {
            aStrings[1] = "02";
        }
        if (aStrings[1].equals("Mar")) {
            aStrings[1] = "03";
        }
        if (aStrings[1].equals("Apr")) {
            aStrings[1] = "04";
        }
        if (aStrings[1].equals("May")) {
            aStrings[1] = "05";
        }
        if (aStrings[1].equals("Jun")) {
            aStrings[1] = "06";
        }
        if (aStrings[1].equals("Jul")) {
            aStrings[1] = "07";
        }
        if (aStrings[1].equals("Aug")) {
            aStrings[1] = "08";
        }
        if (aStrings[1].equals("Sep")) {
            aStrings[1] = "09";
        }
        if (aStrings[1].equals("Oct")) {
            aStrings[1] = "10";
        }
        if (aStrings[1].equals("Nov")) {
            aStrings[1] = "11";
        }
        if (aStrings[1].equals("Dec")) {
            aStrings[1] = "12";
        }
        return aStrings[2].substring(0, 4) + aStrings[1] + aStrings[0] + aStrings[2].substring(5).replace(":", "");
    }
}
