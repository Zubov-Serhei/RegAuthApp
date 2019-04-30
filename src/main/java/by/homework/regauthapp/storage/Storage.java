package by.homework.regauthapp.storage;

import by.homework.regauthapp.entity.Admin;
import by.homework.regauthapp.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей Зубов on 11.04.2019.
 */
public class Storage {
    private static Admin admin = new Admin("admin", "Sergey","123",true);
    public static List<User> storage = new ArrayList();
    static{
        storage.add(admin);
        storage.add(new User("zubov","Sergey","password"));
    }
}
