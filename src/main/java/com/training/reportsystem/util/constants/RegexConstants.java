package com.training.reportsystem.util.constants;

public interface RegexConstants {

    String USERNAME_REGEX = "[a-zA-Z0-9]{2,20}+";
    String PASSWORD_REGEX = "[a-zA-Z0-9]{4,20}+";

    String FIRST_NAME_REGEX = "[а-яА-ЯёЁa-zA-Z`-]{1,24}+";
    String LAST_NAME_REGEX = "[а-яА-ЯёЁa-zA-Z`-]{1,24}+";
    String IDENTIFICATION_CODE_REGEX = "[0-9]{9}";

    String DATE_REGEX = "[0-9]{4}[-]{1}[0-9]{2}[-][0-9]{2}";
    String NUMBER = "[0-9.]{1,10}+";
    String MESSAGE = "[а-яА-ЯёЁa-zA-Z0-9,.`\\-\\s\\\\(\\)!?;:]{1,250}+";
    String MONEY = "[0-9]{1,16}.?[0-9]{1,2}";
}
