package by.homework.regauthapp.service.impl;

import by.homework.regauthapp.dao.UserDAO;
import by.homework.regauthapp.dao.daofactory.DAOFactory;
import by.homework.regauthapp.entity.User;
import by.homework.regauthapp.service.UserService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей Зубов on 30.04.2019.
 */
public class SQLUserService implements UserService{
    @Override
    public List<User> authentication(User user) {
        UserDAO sqlUserDAO = DAOFactory.getDAOFactory().getSQLUserDAO();
        User usr = sqlUserDAO.authentication(user);
        List<User> users = null;
        if(usr!=null) {
            if (usr.getRole()) {
                users = new ArrayList<>();
                users.addAll(sqlUserDAO.getAllUsers());
                return users;
            } else {
                users = new ArrayList<>();
                users.add(usr);
                return users;
            }
        }else return null;
    }

    @Override
    public boolean registration(User user) {
        UserDAO sqlUserDAO = DAOFactory.getDAOFactory().getSQLUserDAO();
        return sqlUserDAO.registration(user);
    }
}
