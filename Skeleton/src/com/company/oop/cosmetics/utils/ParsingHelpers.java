package com.company.oop.cosmetics.utils;

import com.company.oop.cosmetics.models.enums.GenderType;

public class ParsingHelpers {

    public static final String NO_SUCH_GENDERTYPE_ENUM = "None of the enums in GenderType matches the value %s";

    public static double tryParseDouble(String valueToParse, String errorMessage) {
        try {
            return Double.parseDouble(valueToParse);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static int tryParseInt(String valueToParse, String errorMessage) {
        try {
            return Integer.parseInt(valueToParse);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
