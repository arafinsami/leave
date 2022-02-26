package com.leave.utils;


import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public class StringUtils {

    public static boolean isNotEmpty(String str) {
        return Objects.nonNull(str) && str.trim().length() > 0;
    }

    public static boolean nonNull(Object obj) {
        return Objects.nonNull(obj);
    }

    public static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }

    public static boolean isNotEmpty(Integer integer) {
        return Objects.nonNull(integer) && integer > 0;
    }

    public static boolean isEmpty(String str) {
        return !isNotEmpty(str);
    }

    public static boolean isEmpty(Integer integer) {
        return !isNotEmpty(integer);
    }

    public static boolean isEmptyArr(Set<?> strArr) {
        return strArr.size() == 0;
    }

    public static boolean isNumericString(String code) {
        return code.matches("[0-9]+");
    }

    public static boolean isAnyEmpty(String... strings) {
        return Arrays.stream(strings).anyMatch(StringUtils::isEmpty);
    }

    public static boolean isAllNotEmpty(String... strings) {
        return Arrays.stream(strings).noneMatch(StringUtils::isEmpty);
    }

    public static boolean isNotEmpty(Object obj) {
        return Objects.nonNull(obj);
    }

    public static String trim(String str) {
        return str.trim();
    }
}
