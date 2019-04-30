package by.homework.regauthapp.service.impl;

import by.homework.regauthapp.dao.daofactory.DAOFactory;
import by.homework.regauthapp.dao.UserDAO;
import by.homework.regauthapp.entity.User;
import by.homework.regauthapp.service.UserService;
import by.homework.regauthapp.storage.Storage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей Зубов on 11.04.2019.
 */
public class UserServiceImpl implements UserService {
    @Override
    public List<User> authentication(User user) {
        UserDAO userDAO = DAOFactory.getDAOFactory().getUserDAO();
        User usr = userDAO.authentication(user);
        if(usr!=null) {
            if (usr.getRole()) {
                return userDAO.getAllUsers();
            } else {
                List<User> list = new ArrayList<>();
                list.add(usr);
                return list;
            }
        }else return null;
    }

    @Override
    public boolean registration(User user) {
        UserDAO userDAO = DAOFactory.getDAOFactory().getUserDAO();
        return userDAO.registration(user);
    }
}
