package com.online.exams.system.core.util;

import org.apache.commons.lang.StringUtils;

/**
 * Desc: User: HaiNan.Wang Date: 15/10/10
 */
public class StringUtil {

    // 邮箱：
    // 1、显示后缀
    // 2、显示前2位，后1位数字。 当3位数时，只显示中间1位。当2位数时，全部显示
    public static String processEmail(String email) {
        String ret = null;
        if (StringUtils.isNotBlank(email)) {
            String suffix = email.substring(email.lastIndexOf("@"));
            String name = email.substring(0, email.lastIndexOf("@"));
            if (name.length() == 3) {
                name = "*" + name.charAt(1) + "*";
            } else if (name.length() > 3) {
                char[] arr = name.toCharArray();
                for (int i = 2; i < arr.length - 1; i++) {
                    arr[i] = '*';
                }
                name = String.valueOf(arr);
            }
            ret = name + suffix;
        }
        return ret;
    }

    // 手机：显示前3位，后2位数字。 其它隐藏
    public static String processPhone(String phone) {
        String ret = null;
        if (StringUtils.isNotBlank(phone)) {
            char[] arr = phone.toCharArray();
            for (int i = 3; i < arr.length - 2; i++) {
                arr[i] = '*';
            }
            ret = String.valueOf(arr);
        }
        return ret;
    }


    public static String generateRandomNum(boolean numberFlag, int length) {
        StringBuffer retStr = null;
        String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijklmnopqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = new StringBuffer();
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr.append(strTable.charAt(intR));
            }
            // 最少包含两个数字
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);

        return retStr.toString();
    }

    public static boolean isPhoneNumber(String phone) {
        return StringUtils.isNotBlank(phone) && 11 == phone.length() && StringUtils.containsOnly(phone, "0123456789+");
    }

    /**
     * 截取字符串，末尾拼接replaceStr
     * @param targetStr
     * @param replaceStr
     * @param length
     * @return
     */
    public static String subString(String targetStr, String replaceStr, int length) {
        if (StringUtils.isEmpty(targetStr) || targetStr.length() <= length) {
            return targetStr;
        }
        return targetStr.substring(0, length) + (replaceStr == null ? "" : replaceStr);
    }
}
