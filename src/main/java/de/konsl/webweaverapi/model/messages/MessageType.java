package de.konsl.webweaverapi.model.messages;

import java.util.Arrays;
import java.util.Objects;

public enum MessageType {
    FOLDER_FILE_UPLOAD("1"),
    NEW_FORUM_COMMENT("2"),
    NEW_COURSE("3"),
    UNKNOWN_4("4"),
    PASSWORD_CHANGED("5"),
    NEW_FORUM_POST("6"),
    FILE_UPLOAD("7"),
    FILE_DOWNLOAD("8"),
    UNKNOWN_9("9"),
    ADDED_TO_MESSENGER("10"),
    UNKNOWN_11("11"),
    CALENDAR_REMINDER("12"),
    NEW_MAIL("13"),
    NEW_GUESTBOOK_ENTRY("14"),
    REQUEST_PASSWORD_RESET_CODE("15"),
    UNKNOWN_16("16"),
    UNKNOWN_17("17"),
    UNKNOWN_18("18"),
    NEW_POLL("19"),
    UNKNOWN_20("20"),
    RESOURCE_FAULTY("21"),
    RESOURCE_REPAIRED("22"),
    NEW_BLOG_COMMENT("23"),
    NEW_BLOG_ENTRY("24"),
    NEW_LEARNING_LOG_ENTRY("25"),
    NEW_LEARNING_LOG_ENTRY_COMMENT("26"),
    NEW_LEARNING_LOG_COMMENT("27"),
    NEW_LEARNING_LOG("28"),
    NEW_NOTIFICATION("29"),
    NEW_APPOINTMENT("30"),
    NEW_POLL2("31"),
    UNKNOWN_32("32"),
    NEW_TRUST("33"),
    UNKNOWN_34("34"),
    UNAUTHORIZED_LOGIN_LOCATION("35"),
    NEW_WALL_ENTRY("36"),
    NEW_WALL_COMMENT("37"),
    NEW_SUBSTITUTION_PLAN("38"),
    NEW_TEACHER_NOTIFICATION("39"),
    NEW_STUDENT_NOTIFICATION("40"),
    PENDING_QUICK_MESSAGE("41"),
    COURSELET_CORRECTED("42"),
    NEW_BOOKMARK("43"),
    UNKNOWN_44("44"),
    RESOURCE_BOOKED("45"),
    NEW_TASK("46"),
    NEW_FORM_SUBMISSION("47"),
    UNKNOWN_48("48"),
    NEW_CONSULTATION_HOUR_BOOKED("49"),
    NEW_COURSELET("50"),
    NEW_LEARNING_PLAN("51");
    private final String value;

    MessageType(String _value) {
        value = _value;
    }

    public String getValue() {
        return value;
    }

    public static MessageType of(String value) {
        return Arrays.stream(values())
                .filter(e -> Objects.equals(e.value, value))
                .findFirst().orElse(null);
    }
}
