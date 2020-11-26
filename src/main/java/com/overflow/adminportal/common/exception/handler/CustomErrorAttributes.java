package com.overflow.adminportal.common.exception.handler;

import com.overflow.adminportal.common.constant.Constants;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    private static final DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_yyyy_MM_dd_hh_mm_a);

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {

        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);

        Object timestamp = errorAttributes.get(Constants.TIMESTAMP);
        if (timestamp == null) {
            errorAttributes.put(Constants.TIMESTAMP, dateFormat.format(new Date()));
        } else {
            errorAttributes.put(Constants.TIMESTAMP, dateFormat.format((Date) timestamp));
        }

        return errorAttributes;
    }

}