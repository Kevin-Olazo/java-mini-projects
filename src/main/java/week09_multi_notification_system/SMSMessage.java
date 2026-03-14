package week09_multi_notification_system;

import week09_multi_notification_system.util.Priority;

public class SMSMessage extends Message {
    public SMSMessage(String content, Priority priority) {
        super(content, priority);
    }
}
