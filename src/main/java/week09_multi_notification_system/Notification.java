package week09_multi_notification_system;

public class Notification<T> {
    private String id;
    private T payload;

    public Notification(T payload, String id) {
        this.payload = payload;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
