package week09_multi_notification_system;

import java.util.*;

public class NotificationService {

    // The core storage using Wildcards
    private Map<String, NotificationQueue<? extends Message>> queues = new HashMap<>();

    // TODO: Implement this method returning Optional (never return null!)
    public Optional<Notification<?>> findNotificationById(String id) {
        // Your logic here
        return Optional.empty();
    }

    // TODO: Implement this method using Optional chaining (map/flatMap) and orElseThrow
    public Message getMessagePayloadOrThrow(String notificationId) {
        // Use findNotificationById here!
        return null;
    }

    // --- Generic Utility Methods ---

    // TODO: Implement this generic method with bounds
    public static <T extends Message> List<T> filterByPriority(List<T> messages, /* Priority type */ priority) {
        return new ArrayList<>();
    }

    // TODO: Implement this generic method to find the most urgent message (relies on Comparable)
    public static <T extends Message> Optional<T> findMostUrgent(List<T> messages) {
        return Optional.empty();
    }
}
