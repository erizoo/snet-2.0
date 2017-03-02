package by.boiko.snet.model;


public class Email {

    private String subject;
    private String body;
    private String from;

    public Email() {
    }

    public Email(String subject, String body, String from) {
        this.subject = subject;
        this.body = body;
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "Email{" +
                "subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", from='" + from + '\'' +
                '}';
    }
}
