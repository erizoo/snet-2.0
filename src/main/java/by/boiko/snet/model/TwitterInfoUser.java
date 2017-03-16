package by.boiko.snet.model;
import javax.persistence.*;

@Entity
@Table(name = "twitter")
public class TwitterInfoUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NICK_NAME")
    private String nickName;

    public TwitterInfoUser() {
    }

    public TwitterInfoUser(String nickName) {
        this.nickName = nickName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "TwitterInfoUser{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

