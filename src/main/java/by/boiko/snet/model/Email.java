package by.boiko.snet.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mail")
public class Email {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "SUBJECT_EMAIL")
    private String subject;

    @Column(name = "BODY_EMAIL")
    private String body;

    @Column(name = "FROM_EMAIL")
    private String from;

    @Column(name = "TIME_EMAIL")
    private LocalDateTime createdTimestamp; //TODO подумать на форматом

    public Email() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }
}
