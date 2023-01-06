package de.konsl.webweaverapi.model;

import java.util.Arrays;
import java.util.Objects;

public enum FocusObject {
    GLOBAL(""),
    ADMINISTRATION("administration"),
    MAILBOX("mailbox"),
    MESSENGER("messenger"),
    MEMBERS("members"),
    ADDRESSES("addresses"),
    CALENDAR("calendar"),
    TASKS("tasks"),
    NOTES("notes"),
    BOARD("board"),
    BOARD_TEACHER("board_teacher"),
    BOARD_PUPIL("board_pupil"),
    FORUM("forum"),
    LICENSES("licenses"),
    FILES("files"),
    MEMBER("member"),
    RESOURCE_MANAGEMENT("resource_management"),
    EXTERNAL("external"),
    SESSION_FILES("session_files"),
    PROFILE("profile"),
    MESSAGES("messages"),
    WIKI("wiki"),
    SETTINGS("settings"),
    PROXY("proxy"),
    TRUSTS("trusts"),
    COURSELETS("courselets"),
    ABUSE("abuse");
    private final String value;

    FocusObject(String _value) {
        value = _value;
    }

    public String getValue() {
        return value;
    }

    public static FocusObject of(String value) {
        return Arrays.stream(values())
                .filter(e -> Objects.equals(e.value, value))
                .findFirst().orElse(null);
    }
}
