package by.boiko.snet.model;

import javax.persistence.*;

@Entity
@Table(name = "instagram")
public class InstagramInfoUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "FULL_NAME")
    private String fullName;


    public InstagramInfoUser() {
    }


    public InstagramInfoUser(String fullName) {
        this.fullName = fullName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

