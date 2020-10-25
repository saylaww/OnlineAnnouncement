package uz.pdp;

public class Message {
    private String title;
    private String body;
    private User sender;
    private Announcement announcement;
    public boolean isbool;

    public Message(String title, String body, User sender, Announcement announcement) {
        this.title = title;
        this.body = body;
        this.sender = sender;
        this.announcement = announcement;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }
}
