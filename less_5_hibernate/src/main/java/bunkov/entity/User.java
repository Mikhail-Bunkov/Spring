package bunkov.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "AllUsers", query = "select u from User u"),
        @NamedQuery(name = "usersWithAgeLesser25", query = "select  u from User u where u.age < :age"),
        @NamedQuery(name = "countUsers", query = "select count(u) from User u")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 512,nullable = false)
    private String username;

    @Column(nullable = false)
    private Integer age;

//    @Transient // если не нужна запись каких либо полей в бд
//    private String foo;

    public User() {
    }

    public User(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
