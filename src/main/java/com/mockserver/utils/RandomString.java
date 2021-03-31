package com.mockserver.utils;
import java.util.Random;

public class RandomString {

    public static final String ALL_CHAR = "-_#&$@+-*/%()[]0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String LETTER_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String NUMBER_CHAR = "0123456789";

    public static final String SPECIAL_CHAR = "-_#&$@+-*/%()[]";

    public static final String LETTER_NUMBER_CHAR = LETTER_CHAR + NUMBER_CHAR;

    /**
     * 返回一个定长的随机字符串
     *
     * @param chars  模型串
     * @param length 随机长度
     * @return
     */
    public static String randomString(String chars, int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个定长的随机字符串字母全部大写
     *
     * @param chars  模型串
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String randomLowerString(String chars, int length) {
        return randomString(chars, length).toLowerCase();
    }

    /**
     * 返回一个定长的随机字符串字母全部小写
     *
     * @param chars  模型串
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String randomUpperString(String chars, int length) {
        return randomString(chars, length).toLowerCase();
    }

    /**
     * 生成一个定长的纯0字符串
     *
     * @param length 字符串长度
     * @return 纯0字符串
     */
    public static String randomZeroString(int length) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append("0");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int counter = 1;
        String NUM_CHAR = "12356789";
        for (int index = 600000; counter <= 1000; index++) {
            if (String.valueOf(index).indexOf("3") < 0 && String.valueOf(index).indexOf("4") < 0) {
                System.out.println(counter + ", " + index + ", " + randomString(NUM_CHAR, 8));
                counter++;
            }
        }
    }
}