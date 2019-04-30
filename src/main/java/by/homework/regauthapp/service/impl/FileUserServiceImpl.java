package by.homework.regauthapp.service.impl;

import by.homework.regauthapp.dao.UserDAO;
import by.homework.regauthapp.dao.daofactory.DAOFactory;
import by.homework.regauthapp.entity.User;
import by.homework.regauthapp.service.UserService;
import by.homework.regauthapp.storage.Storage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей Зубов on 15.04.2019.
 */
public class FileUserServiceImpl implements UserService{
    @Override
    public List<User> authentication(User user) {
        UserDAO fileUserDAO = DAOFactory.getDAOFactory().getFileUserDAO();
        User usr = fileUserDAO.authentication(user);
        List<User> users = null;
        if(usr!=null) {
            if (usr.getRole()) {
                users = new ArrayList<>();
                users.add(usr);
                users.addAll(fileUserDAO.getAllUsers());
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
        UserDAO fileUserDAO = DAOFactory.getDAOFactory().getFileUserDAO();
        return fileUserDAO.registration(user);
    }
}
