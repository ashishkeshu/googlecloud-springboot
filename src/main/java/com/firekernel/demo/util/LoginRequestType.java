package com.firekernel.demo.util;

public enum LoginRequestType {
    EMAIL("EMAIL"), CONTACT_NUMBER("CONTACT_NUMBER"), FB("FB"), GOOGLE("GOOGLE");

    private String loginRequestType;

    LoginRequestType(String loginRequestType) {
        this.loginRequestType = loginRequestType;
    }

    public String getStringName() {
        return loginRequestType;
    }

    public static LoginRequestType getLoginRequestType(String loginRequestType) {
        if (loginRequestType.equalsIgnoreCase(LoginRequestType.EMAIL.getStringName())) {
            return LoginRequestType.EMAIL;
        } else if (loginRequestType.equalsIgnoreCase(LoginRequestType.CONTACT_NUMBER.getStringName())) {
            return LoginRequestType.CONTACT_NUMBER;
        } else if (loginRequestType.equalsIgnoreCase(LoginRequestType.FB.getStringName())) {
            return LoginRequestType.FB;
        } else if (loginRequestType.equalsIgnoreCase(LoginRequestType.GOOGLE.getStringName())) {
            return LoginRequestType.GOOGLE;
        }

        return LoginRequestType.EMAIL;
    }
}
