package by.homework.regauthapp.dao.impl;

import by.homework.regauthapp.dao.UserDAO;
import by.homework.regauthapp.entity.User;
import by.homework.regauthapp.storage.Storage;

import java.util.List;

/**
 * Created by Сергей Зубов on 11.04.2019.
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public User authentication(User user) {
            for(User usr: Storage.storage){
                if(usr.getLogin().equals(user.getLogin())&&usr.getPassword().equals(user.getPassword())){
                    return usr;
                }
            }
        return null;
    }

    @Override
    public boolean registration(User user) {
        for(User usr:Storage.storage){
            if(usr.getLogin().toLowerCase().equals(user.getLogin().toLowerCase())) return false;
        }
        Storage.storage.add(user);
        for(User usr : Storage.storage){
            if(usr.equals(user)) return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return Storage.storage;
    }
}
