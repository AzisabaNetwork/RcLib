package net.azisaba.rclib.utils;

public class CraftMath {
    /* CraftMathUtilの実装クラス */

    public static boolean isInt(String target) {
        /* 対象が整数かを判定する: string */
        try {Integer.parseInt(target);}
        catch (Exception e) {return false;}
        return true;
    }

    public static boolean isInt(char target) {
        /* 対象が整数かを判定する: char */
        return isInt(String.valueOf(target));
    }
}
