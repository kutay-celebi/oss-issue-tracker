package com.kuartz.core.auth.enumeration;

import com.kuartz.core.common.enumaration.KzEnum;

public enum Gender implements KzEnum {
    MALE,
    FEMALE;

    //fixme
    @Override
    public String label() {
        return null;
    }

    @Override
    public int code() {
        return 0;
    }
}
