package by.homework.regauthapp.service.servicefactory;

import by.homework.regauthapp.service.UserService;
import by.homework.regauthapp.service.impl.FileUserServiceImpl;
import by.homework.regauthapp.service.impl.SQLUserService;
import by.homework.regauthapp.service.impl.UserServiceImpl;

/**
 * Created by Сергей Зубов on 11.04.2019.
 */
public class ServiceFactory {
    private static ServiceFactory ourInstance = new ServiceFactory();
    private UserService userService = new UserServiceImpl();
    private UserService fileUserService = new FileUserServiceImpl();
    private UserService sqlUserService = new SQLUserService();

    public static ServiceFactory getServiceFactory() {
        return ourInstance;
    }
    public UserService getUserService(){ return userService;}
    public UserService getFileUserService(){
        return fileUserService;
    }
    public UserService getSQLUserService() {return sqlUserService;}
    private ServiceFactory() {
    }
}
