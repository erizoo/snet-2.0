package by.boiko.snet.model;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "LAST_NAME")
    @Size(max = 20, message = "value lastName - exceeds the permissible value")
    private String lastName;

    @Column(name = "FIRST_NAME")
    @Size(max = 20, message = "value firstName - exceeds the permissible value")
    private String firstName;

    @Column(name = "age")
    private int age;

    @Column(name = "SEX")
    private String sex; //TODO подумать как реализовать по-другому

    @Column(name = "CITY")
    @Size(max = 20, message = "value city - exceeds the permissible value")
    private String city;

    @Column(name = "INCOME")
    private int income;

    public User() {
    }

    public User(String lastName, String firstName, int age, String sex, String city, int income) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.sex = sex;
        this.city = city;
        this.income = income;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}