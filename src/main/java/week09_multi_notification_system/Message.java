package week09_multi_notification_system;

import week09_multi_notification_system.util.Priority;

public abstract class Message implements Comparable<Message> {
    private String content;
    private Priority priority;

    public Message(String content, Priority priority) {
        if (priority == null){
            throw new IllegalArgumentException("Priority cannot be null");
        }
        if (content == null || content.trim().isEmpty()){
            throw new IllegalArgumentException("Message cannot be empty");
        }

        this.content = content;
        this.priority = priority;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Message other) {
        if (other == null){
            throw new IllegalArgumentException("Objetivo invalido");
        }
        return this.priority.compareTo(other.priority);
    }
}
