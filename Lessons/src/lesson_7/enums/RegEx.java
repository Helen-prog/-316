package lesson_7.enums;

import java.util.regex.Pattern;

public enum RegEx {
    UPPER("[A-Z]+"), LOWER("[a-z]+"), NUMERIC("[+-]?[0-9]+");

    private final Pattern pattern;

    RegEx(final String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public boolean test(final String input) {
        return pattern.matcher(input).matches();
    }
}
