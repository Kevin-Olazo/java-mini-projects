package week09_multi_notification_system;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NotificationQueue<T extends Message> {
    private List<Notification<T>> queue = new ArrayList<>();

    public void add(Notification<T> notification) {
        if (notification == null){
            throw new IllegalArgumentException("Notificación no puede ser null");
        }
        queue.add(notification);
    }

    public Optional<Notification<T>> getNext(){
        if (!queue.isEmpty()){
            return Optional.of(queue.remove(0));
        }

        return Optional.empty();
    }

    public Optional<Notification<T>> findById(String id){
        for(Notification<T> t : queue){
            if (id.equals(t.getId())){
                return Optional.of(t);
            }
        }
        return Optional.empty();

    }

}
