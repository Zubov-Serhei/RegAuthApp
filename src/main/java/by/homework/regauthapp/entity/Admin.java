package by.homework.regauthapp.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Сергей Зубов on 11.04.2019.
 */
@Entity
@Table(name = "isAdmin")
@DiscriminatorValue(value="Y")
public class Admin extends User{
    public Admin(){}

    public Admin(String login, String name, String password, boolean role) {
        super(login, name, password);
        this.role = role;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                "}\n";
    }
}
