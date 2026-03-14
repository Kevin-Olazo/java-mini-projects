package week09_multi_notification_system;

import java.util.ArrayList;
import java.util.List;

public class NotificationQueue<T extends Message> {
    private List<Notification<T>> queue = new ArrayList<>();
}
