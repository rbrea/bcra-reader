package com.icetea.bcra.reader.utils;

import java.text.Normalizer;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils
    extends org.apache.commons.lang3.StringUtils {

    private static final String ACCENT_PATTERN = "[^\\p{ASCII}]";
    public static final String MINUS = "−";
    public static final String SPACE = " ";
    public static final String UNDERSCORE = "_";
    public static final String COMMA = ",";

    public static final String DOT = ".";
    public static final String NULL = "null";
    public static final String AT = "@";
    public static final String PLUS = "+";
    public static final String DASH = "-";
    public static final String DASH_SPACED = SPACE + DASH + SPACE;
    public static final String ASTERISK = "*";
    public static final String PERCENTAGE = "%";
    public static final String PIPE = "|";
    public static final String SLASH = "/";
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String SEMICOLON = ";";
    public static final String SHARP = "#";
    public static final String BRACKET_LEFT = "(";
    public static final String BRACKET_RIGHT = ")";
    public static final String AMPERSAND = "&";
    public static final String QUESTION = "?";
    public static final String EQ = "=";

    public static final String ZERO = "0";
    public static final String ONE = "1";
    public static final String TWO = "2";
    public static final String THREE = "3";
    public static final String FOUR = "4";
    public static final String FIVE = "5";
    public static final String SIX = "6";
    public static final String SEVEN = "7";
    public static final String EIGHT = "8";
    public static final String NINE = "9";
    public static final String TEN = "10";
    public static final String ELEVEN = "11";

    public static final String X = "X";
    public static final String X_MINUS = "x";

    public static final String ANY = "ANY";
    public static final String N = "N";
    public static final String Y = "Y";
    public static final String TOTAL = "TOTAL";
    public static final String E = "E";
    public static final String S = "S";
    public static final String J = "J";
    public static final String K = "K";
    public static final String Y_MINUS = "y";
    public static final String N_MINUS = "n";
    public static final String ENIE = "Ñ";
    public static final String ENIE_MINUS = "ñ";

    public static final String COLON = ":";
    public static final String LINE_JUMP = "\\n";
    public static final String DOT_1 = "0.1";

    public static String convertIfNegative(final String value) {
        String target = value;
        if (StringUtils.endsWith(target, MINUS)) {
            target = DASH + StringUtils.remove(target, MINUS);
        } else if (StringUtils.endsWith(target, DASH)) {
            target = DASH + StringUtils.remove(target, DASH);
        } else if (StringUtils.contains(value, BRACKET_LEFT) && StringUtils.contains(value, BRACKET_RIGHT)) {
            target = StringUtils.remove(value, BRACKET_LEFT);
            target = StringUtils.remove(target, BRACKET_RIGHT);
            target = DASH + target;
        }

        return target;
    }

    public static String normalize(String txt) {
        return Normalizer.normalize(txt, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", EMPTY)
            .replaceAll(SPACE, PLUS);
    }

    public static String addYearFromDate(String partialDate, LocalDateTime fromDate) {
        return partialDate + SLASH + fromDate.getYear();
    }

    public static String emptyWhenNull(String value) {
        return value != null ? value : EMPTY;
    }

    public static String[] getNames(Class<? extends Enum<?>> e) {
        return Arrays.toString(e.getEnumConstants()).replaceAll("\\[|]", EMPTY).split(", ");
    }

    public static String valueOf(Integer obj) {
        return (obj == null) ? EMPTY : String.valueOf(obj);
    }

    public static String valueOf(Long obj) {
        return (obj == null) ? EMPTY : String.valueOf(obj);
    }

    public static String toString(Collection<String> collection) {
        if (collection == null) {
            return EMPTY;
        }
        StringBuilder buff = new StringBuilder();
        boolean isFirst = true;
        for (String s : collection) {
            if (isFirst) {
                buff.append(s);
                isFirst = false;
            } else {
                buff.append(COMMA).append(s);
            }
        }

        return buff.toString();
    }

    public static String nullIfNullString(String input) {
        if (input == null || StringUtils.equalsIgnoreCase(input, StringUtils.NULL)) {
            return null;
        }

        return input;
    }

    public static String nullWhenEmpty(String value) {
        return value != null && value.length() > 0 ? value : null;
    }

    public static boolean in(String valueToMatch, String... values) {
        if (values == null) {
            return false;
        }
        for (String value : values) {
            if (StringUtils.equals(value, valueToMatch)) {
                return true;
            }
        }

        return false;
    }

    public static boolean notIn(String valueToMatch, String... values) {
        if (values == null) {
            return false;
        }

        return !in(valueToMatch, values);
    }

    public static String removeSpecialCharacters(final String value) {
        if (value == null) {
            return null;
        }
        if (StringUtils.isBlank(value)) {
            return EMPTY;
        }

        return value.replaceAll("[^\\w\\s]", EMPTY);
    }

    public static String getOnlyNumbers(final String value) {
        if (value == null) {
            return null;
        }
        if (StringUtils.isBlank(value)) {
            return EMPTY;
        }

        return value.replaceAll("\\D+", EMPTY);
    }

    public static String insertBefore(String input, int pos, String value) {
        if (input == null) {
            return null;
        }
        if (input.length() < pos || value == null) {
            return input;
        }

        StringBuilder respBuilder = new StringBuilder();
        respBuilder.append(EMPTY);
        for (int i = 0; i < input.length(); i++) {
            if (pos == i) {
                respBuilder.append(value);
            }
            respBuilder.append(input.charAt(i));
        }
        return respBuilder.toString();
    }

    public static String getOnlyNumbersWithEndX(final String value) {
        if (value == null) {
            return null;
        }
        if (StringUtils.isBlank(value)) {
            return EMPTY;
        }
        String lastX = X;
        int x = StringUtils.lastIndexOf(value, lastX);
        if (x == -1) {
            lastX = X_MINUS;
            x = StringUtils.lastIndexOf(value, lastX);
        }

        if (x == value.length() - 1) {
            return value.replaceAll("\\D+", EMPTY) + lastX;
        }

        return value.replaceAll("\\D+", EMPTY);
    }

    @SuppressWarnings("unchecked")
    public static <T> T cast(String value, Class<T> clazz) {
        if (value == null) {
            return null;
        }
        if (clazz == Boolean.class) {
            return (T) Boolean.valueOf(value);
        }
        if (clazz == String.class) {
            return (T) value;
        }
        if (clazz == Long.class) {
            return (T) Long.valueOf(value);
        }
        if (clazz == Integer.class) {
            return (T) Integer.valueOf(value);
        }

        return null;
    }

    public static String removeSymbols(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", EMPTY);
    }

    public static String removeSymbolsExceptSpaces(String input) {
        if (StringUtils.isBlank(input)) {
            return input;
        }

        return input.replace(AMPERSAND, Y_MINUS).replace(UNDERSCORE, SPACE).replaceAll("[^a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\h]", EMPTY)
            .replace(ENIE_MINUS, N_MINUS).replace(ENIE, N).trim().replaceAll(" +", SPACE);
    }

    public static boolean in(String valueToMatch, Collection<String> values) {
        if (values == null) {
            return false;
        }
        for (String value : values) {
            if (StringUtils.equals(value, valueToMatch)) {
                return true;
            }
        }

        return false;
    }

    public static String nvl(String input) {
        return (input == null) ? EMPTY : input;
    }

    public static boolean notIn(String valueToMatch, Collection<String> values) {
        return !in(valueToMatch, values);
    }

    public static String normalizeAccents(String input) {
        if (input == null) {
            return null;
        }
        String output = Normalizer.normalize(input, Normalizer.Form.NFD);
        return output.replaceAll(ACCENT_PATTERN, EMPTY);
    }

    public static boolean equalsIgnoreCaseNormalizedAccents(final String str1, final String str2) {
        final String n1 = normalizeAccents(str1);
        final String n2 = normalizeAccents(str2);

        return equalsIgnoreCase(n1, n2);
    }

    public static boolean haveSpecialCharacers(String input) {
        if (input == null) {
            return false;
        }
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        boolean result = m.find();
        return input.contains(DOT) || result;
    }

    public static String ofuscEmail(String email) {
        if (StringUtils.isNotBlank(email)) {
            String[] parts = email.split(AT);
            if (parts.length > 1) {
                return ofuscString(parts[0]) + AT + parts[parts.length - 1];
            } else {
                return ofuscString(parts[0]);
            }
        } else {
            return email;
        }
    }

    public static String ofuscString(String numberPhone) {
        if (StringUtils.isBlank(numberPhone)) {
            return numberPhone;
        } else {
            if (numberPhone.length() > 1) {
                return numberPhone.charAt(0) + String.join(EMPTY, Collections.nCopies((numberPhone.length() - 1), ASTERISK));
            } else {
                return ASTERISK;
            }

        }
    }

    public static String nvl(Object input) {
        return input == null ? EMPTY : input.toString();
    }

    public static String getCountryCodeByAtp3UserName(String atp3UserName) {
        if (StringUtils.isBlank(atp3UserName)) {
            return atp3UserName;
        } else {
            String[] userSplitName = atp3UserName.split(AT);
            if (userSplitName.length > 1) {
                return StringUtils.substring(userSplitName[1], 0, 2);
            } else {
                return userSplitName[0];
            }
        }
    }

    public static boolean inIgnoreCase(String valueToMatch, String... values) {
        if (values == null) {
            return false;
        }
        for (String value : values) {
            if (StringUtils.equalsIgnoreCase(value, valueToMatch)) {
                return true;
            }
        }

        return false;
    }

}
