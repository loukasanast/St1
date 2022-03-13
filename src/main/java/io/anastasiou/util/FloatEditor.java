package io.anastasiou.util;

import org.springframework.beans.propertyeditors.PropertiesEditor;

public class FloatEditor extends PropertiesEditor {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.isBlank()) {
            setValue(-1);
        }

        try {
            setValue(Float.parseFloat(text));
        } catch(NumberFormatException e) {
            setValue(-1);
        }
    }

    @Override
    public String getAsText() {
        if(getValue() == null) {
            return "";
        } else {
            try {
                if(Float.parseFloat(getValue().toString()) >= 0) {
                    return getValue().toString();
                } else {
                    return "0.0";
                }
            } catch(NumberFormatException e) {
                return "0.0";
            }
        }
    }
}
