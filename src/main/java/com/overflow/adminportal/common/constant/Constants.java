package com.overflow.adminportal.common.constant;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final String DATE_AS_STRING = LocalDateTime.now(ZoneId.of("GMT+6")).toString();
    public static final String TIMESTAMP = "timestamp";
    public static final String DATE_FORMAT_yyyy_MM_dd_hh_mm_a = "yyyy/MM/dd hh:mm a";
    public static final List<String> APPROVAL_TYPES = Arrays.asList("Need", "Not need");
    public static final List<String> ORG_TYPES = Arrays.asList("Educational Institution", "Private Org.", "Bank");

}
