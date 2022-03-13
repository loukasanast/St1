package io.anastasiou.util;

import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class DateEditor extends PropertiesEditor {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println(text);
        if (text == null || text.isBlank()) {
            setValue(Date.from(Instant.now().plus(365, ChronoUnit.DAYS)));
        }

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            setValue(format.parse(text));
        } catch(ParseException e) {
            setValue(Date.from(Instant.now().plus(365, ChronoUnit.DAYS)));
        }
    }

    @Override
    public String getAsText() {
        if(getValue() == null) {
            return "";
        } else {
            SimpleDateFormat format1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

            try {
                Date date = format1.parse(getValue().toString());

                if(date.after(Date.from(Instant.now()))) {
                    date = Date.from(Instant.now());
                }

                return(format2.format(date));
            } catch(ParseException e1) {
                e1.printStackTrace();
                try {
                    Date date = format3.parse(getValue().toString());

                    if(date.after(Date.from(Instant.now()))) {
                        date = Date.from(Instant.now());
                    }

                    return(format2.format(date));
                } catch(ParseException e2) {
                    e2.printStackTrace();
                    return "";
                }
            }
        }
    }
}