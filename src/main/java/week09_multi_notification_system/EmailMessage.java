package week09_multi_notification_system;

import week09_multi_notification_system.util.Priority;

import java.util.Optional;

public class EmailMessage extends Message {

    public EmailMessage(String content, Priority priority) {
        super(content, priority);
    }
}
