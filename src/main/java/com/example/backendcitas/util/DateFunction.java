package com.example.backendcitas.util;

import com.example.backendcitas.enums.DateFormatEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFunction {

    private static final Logger LOGGER = LogManager.getLogger(DateFunction.class);

    public static Date convertToDate(String currentDate, DateFormatEnum formatDateEnum) {

        try {
            if (currentDate == null) return null;

            return new SimpleDateFormat(formatDateEnum.getFormat()).parse(currentDate);
        } catch (Exception e) {
            LOGGER.error("Error parse fecha ", e);
            return null;

        }
    }

    public static String convertToString(Date date, DateFormatEnum typeFormat) {
        return date == null ? null : new SimpleDateFormat(typeFormat.getFormat()).format(date);
    }

}
