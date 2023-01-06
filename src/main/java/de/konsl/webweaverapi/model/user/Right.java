package de.konsl.webweaverapi.model.user;

import java.util.Arrays;
import java.util.Objects;

public enum Right {
    ADDRESS("address"),
    ADDRESS_ADMIN("address_admin"),
    ADDRESS_WRITE("address_write"),
    ADMIN_ADMIN("admin_admin"),
    BLOG_ADMIN("blog_admin"),
    BLOG_WRITE("blog_write"),
    BOARD("board"),
    BOARD_ADMIN("board_admin"),
    BOARD_PUPIL("board_pupil"),
    BOARD_PUPIL_ADMIN("board_pupil_admin"),
    BOARD_PUPIL_WRITE("board_pupil_write"),
    BOARD_TEACHER_ADMIN("board_teacher_admin"),
    BOOKMARKS("bookmarks"),
    BOOKMARKS_ADMIN("bookmarks_admin"),
    BOOKMARKS_WRITE("bookmarks_write"),
    CALENDAR("calendar"),
    CALENDAR_ADMIN("calendar_admin"),
    CALENDAR_WRITE("calendar_write"),
    CHAT_ADMIN("chat_admin"),
    CHAT_WRITE("chat_write"),
    CONFERENCE_ADMIN("conference_admin"),
    CONFERENCE_WRITE("conference_write"),
    CONSULTATION_HOURS_ADMIN("consultation_hours_admin"),
    CONSULTATION_HOURS_WRITE("consultation_hours_write"),
    COURSELETS("courselets"),
    COURSELETS_ADMIN("courselets_admin"),
    COURSELETS_WRITE("courselets_write"),
    FILES("files"),
    FILES_ADMIN("files_admin"),
    FILES_WRITE("files_write"),
    FORMS("forms"),
    FORMS_ADMIN("forms_admin"),
    FORUM_ADMIN("forum_admin"),
    FORUM_WRITE("forum_write"),
    IMAGES("images"),
    IMAGES_ADMIN("images_admin"),
    LEARNING_LOG_WRITE("learning_log_write"),
    LEARNING_PLAN("learning_plan"),
    LEARNING_PLAN_ADMIN("learning_plan_admin"),
    LEARNING_PLAN_WRITE("learning_plan_write"),
    MAIL("mail"),
    MAIL_ADMIN("mail_admin"),
    MAILING_LISTS_ADMIN("mailing_lists_admin"),
    MEMBERS("members"),
    MEMBERS_ADMIN("members_admin"),
    MEMBERS_WRITE("members_write"),
    MESSENGER_WRITE("messenger_write"),
    META("meta"),
    META_ADMIN("meta_admin"),
    META_WRITE("meta_write"),
    NOTES_WRITE("notes_write"),
    PASSWORD("password"),
    POLL("poll"),
    POLL_ADMIN("poll_admin"),
    PROFILE("profile"),
    PROFILE_WRITE("profile_write"),
    RESOURCE_MANAGEMENT("resource_management"),
    RESOURCE_MANAGEMENT_ADMIN("resource_management_admin"),
    SETTINGS("settings"),
    SHOWCASE("showcase"),
    SHOWCASE_WRITE("showcase_write"),
    SUBSTITUTION_PLAN("substitution_plan"),
    SUBSTITUTION_PLAN_ADMIN("substitution_plan_admin"),
    TASKS("tasks"),
    TASKS_ADMIN("tasks_admin"),
    TASKS_WRITE("tasks_write"),
    TIMETABLE("timetable"),
    TIMETABLE_WRITE("timetable_write"),
    WALL("wall"),
    WEBSITE("website"),
    WEBSITE_ADMIN("website_admin"),
    WIKI_ADMIN("wiki_admin"),
    WIKI_WRITE("wiki_write"),
    WS_GEN("ws_gen"),
    WS_GEN_ADMIN("ws_gen_admin");

    private final String value;

    Right(String _value) {
        value = _value;
    }

    public String getValue() {
        return value;
    }

    public static Right of(String value) {
        return Arrays.stream(values())
                .filter(e -> Objects.equals(e.value, value))
                .findFirst().orElse(null);
    }
}
