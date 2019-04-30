package by.homework.regauthapp.entity;

import javax.persistence.*;

/**
 * Created by Сергей Зубов on 11.04.2019.
 */

@Entity
@Table(name = "users")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="isAdmin",
        discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue(value="N")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    protected Integer id;
    @Column(name = "login")
    protected String login;
    @Column(name = "name")
    protected String name;
    @Column(name = "password")
    protected String password;
    @Column(name = "role")
    protected Boolean role = false;

    public User() {
    }

    public User(String login, String name, String password) {
        this.login = login;
        this.name = name;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", password=" + password +
                '}'+"\n";
    }
}
