package week09_multi_notification_system;

import week09_multi_notification_system.exception.NotificationNotFoundException;
import week09_multi_notification_system.util.Priority;

import java.util.*;
import java.util.stream.Collectors;

public class NotificationService {

    // The core storage using Wildcards
    private Map<String, NotificationQueue<? extends Message>> queues = new HashMap<>();


    public void registerQueue(String type, NotificationQueue<? extends Message> queue) {
        if (queue == null || type == null) {
            throw new IllegalArgumentException("El tipo o Cola no puede ser null");
        }
        queues.put(type, queue);
    }


    // TODO: Implement this method returning Optional (never return null!)
    public Optional<Notification<?>> findNotificationById(String id) {
        for (NotificationQueue<? extends Message> queue : queues.values()) {
            Optional<? extends Notification<? extends Message>> resultado = queue.findById(id);

            if (resultado.isPresent()) {
                // 1. Sacamos la notificación de su caja original
                Notification<?> notif = resultado.get();
                // 2. La metemos en una caja nueva que coincide perfectamente con la firma
                return Optional.of(notif);
            }
        }

        return Optional.empty();
    }

    // TODO: Implement this method using Optional chaining (map/flatMap) and orElseThrow
    public Message getMessagePayloadOrThrow(String notificationId) {
        return findNotificationById(notificationId).map(b -> (Message) b.getPayload()).orElseThrow(() -> new NotificationNotFoundException("Notificacion no encontrada"));
    }

    // --- Generic Utility Methods ---

    // 1. FILTER BY PRIORITY
    public static <T extends Message> List<T> filterByPriority(List<T> messages, Priority priority) {
        return messages.stream().filter(m -> m.getPriority() == priority).collect(Collectors.toList());
    }

    // TODO: Implement this generic method to find the most urgent message (relies on Comparable)
    public static <T extends Message> Optional<T> findMostUrgent(List<T> messages) {
        return messages.stream().min(Comparator.naturalOrder());
    }
}
