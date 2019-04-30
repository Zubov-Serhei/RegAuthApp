package by.homework.regauthapp.dao.daofactory;

import by.homework.regauthapp.dao.UserDAO;
import by.homework.regauthapp.dao.impl.FileUserDAOImpl;
import by.homework.regauthapp.dao.impl.SQLUserDAO;
import by.homework.regauthapp.dao.impl.UserDAOImpl;

/**
 * Created by Сергей Зубов on 11.04.2019.
 */
public class DAOFactory {
    private static DAOFactory ourInstance = new DAOFactory();
    private static UserDAO userDAO = new UserDAOImpl();
    private static UserDAO fileUserDAO = new FileUserDAOImpl();
    private static UserDAO sqlUserDAO = new SQLUserDAO();

    public static DAOFactory getDAOFactory() {
        return ourInstance;
    }
    public UserDAO getUserDAO(){ return userDAO; }
    public UserDAO getFileUserDAO(){ return fileUserDAO;}
    public UserDAO getSQLUserDAO(){return sqlUserDAO;}

    private DAOFactory() {
    }
}
