package com.kuartz.api.issuetracker.common.constraints;

/**
 * @author Kutay Çelebi
 * @since 27.06.2020
 */
public class ProjectConstraints {
    public static final String TABLE_NAME = "KIT_PROJECT";

    public static final int NAME_MIN = 3;
    public static final int NAME_MAX = 150;

    public static final int CODE_MIN = 3;
    public static final int CODE_MAX = 30;
}
