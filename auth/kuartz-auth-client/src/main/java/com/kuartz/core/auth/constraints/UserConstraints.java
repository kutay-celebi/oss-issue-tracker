package com.kuartz.core.auth.constraints;

public final class UserConstraints {

    public static final String TABLE_NAME = "UAA_USER_TABLE";

    public static final int USERNAME_MAX = 40;
    public static final int USERNAME_MIN = 5;

    public static final int EMAIL_MIN = 5;
    public static final int EMAIL_MAX = 100;

    public UserConstraints() {
        throw new UnsupportedOperationException();
    }
}
