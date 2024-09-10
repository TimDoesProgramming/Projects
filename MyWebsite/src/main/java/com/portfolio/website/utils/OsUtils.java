package com.portfolio.website.utils;

public class OsUtils {
    private static String OS = null;

    public static String getOsName() {
        if (OS == null) {
            OS = System.getProperty("os.name");
        }
        return OS;
    }
    public static boolean isWindows() {
        return getOsName().contains("Windows");
    }
    public static boolean isLinux() {
        return (getOsName().contains("nux") || getOsName().contains("nix") || getOsName().contains("aix"));
    }
}
