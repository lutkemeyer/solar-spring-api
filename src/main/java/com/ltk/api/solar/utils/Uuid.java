package com.ltk.api.solar.utils;

import static java.util.UUID.randomUUID;

public class Uuid {

    private static final String TEMPORARY_PREFIX = "TEMP_";

    public static String generate(){
        return randomUUID().toString().toUpperCase().replaceAll("-", "");
    }

    public static String generateTemporary() {
        return TEMPORARY_PREFIX + generate();
    }

    public static boolean isTemporary(String uuid) {
        return uuid == null || uuid.startsWith(TEMPORARY_PREFIX);
    }

}