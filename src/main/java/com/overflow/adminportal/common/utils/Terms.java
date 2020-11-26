package com.overflow.adminportal.common.utils;

public enum Terms {

    MONTHLY("Monthly"),
    WEEKLY("Weekly");

    private final String displayName;

    Terms(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
