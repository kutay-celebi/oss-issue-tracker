package com.kuartz.api.auth.constants;

public final class UAAPrivilegeConstants {

    public static final String PRIVILEGE_FULL = "checkYetki('uaa_privilege')";
    public static final String ROLE_FULL      = "checkYetki('uaa_role')";
    public static final String ADMIN          = "checkYetki('admin')";
    public static final String BASIC          = "checkYetki('basic')";

    public UAAPrivilegeConstants() {
        throw new UnsupportedOperationException();
    }

}
