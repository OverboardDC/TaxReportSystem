package com.training.reportsystem.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Encryptor {

    public static String encrypt(String field){
        return DigestUtils.md2Hex(field);
    }
}
