package week09_multi_notification_system;

import week09_multi_notification_system.util.Priority;

public class PushMessage extends Message{
    public PushMessage(String content, Priority priority) {
        super(content, priority);
    }
}
