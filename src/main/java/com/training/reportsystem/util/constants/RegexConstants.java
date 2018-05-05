package com.training.reportsystem.util.constants;

public interface RegexConstants {

    String USERNAME_REGEX = "[a-zA-Z0-9]{2,20}+";
    String PASSWORD_REGEX = "[a-zA-Z0-9]{4,20}+";

    String FIRST_NAME_REGEX = "[a-zA-Z0-9`-]{1,24}+";
    String LAST_NAME_REGEX = "[a-zA-Z0-9`-]{1,24}+";
    String IDENTIFICATION_CODE_REGEX = "[0-9]{9}";

}
