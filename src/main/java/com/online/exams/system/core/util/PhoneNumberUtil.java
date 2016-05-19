package com.online.exams.system.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhang on 2016/4/3.
 */
public class PhoneNumberUtil {
    public static boolean isMobileNum(String telNum){
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(telNum);
        return m.matches();
    }
}
