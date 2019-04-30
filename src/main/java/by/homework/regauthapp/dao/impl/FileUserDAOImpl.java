package by.homework.regauthapp.dao.impl;

import by.homework.regauthapp.dao.UserDAO;
import by.homework.regauthapp.entity.Admin;
import by.homework.regauthapp.entity.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Сергей Зубов on 15.04.2019.
 */
public class FileUserDAOImpl implements UserDAO {
    @Override
    public User authentication(User user) {
        File file = new File("f:\\Важное\\Java\\IDEA\\BelHard\\J2EEProfLvl\\Java\\RegAuthApp\\src\\main\\java\\by\\homework\\regauthapp\\storage\\usersdata\\"+user.getLogin()+".txt");
        if(file.exists()){
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                String data = br.readLine();
                String[] userData = data.split("\\s");
                User storageUser;
                if(user.getLogin().equals("admin")) {
                    storageUser = new Admin(userData[0], userData[2], userData[1],Boolean.valueOf(userData[3]));
                }else storageUser = new User(userData[0], userData[2], userData[1]);
                if(storageUser.getLogin().equals(user.getLogin())&&storageUser.getPassword().equals(user.getPassword())){
                    return storageUser;
                }
            } catch (FileNotFoundException e) {
                if(br!=null){
                    try {
                        br.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean registration(User user) {
        FileOutputStream fos = null;
        File file = null;
        try {
            file = new File("f:\\Важное\\Java\\IDEA\\BelHard\\J2EEProfLvl\\Java\\RegAuthApp\\src\\main\\java\\by\\homework\\regauthapp\\storage\\usersdata\\"+user.getLogin()+".txt");
            if(file.exists()) return false;
            fos = new FileOutputStream(file);
            byte[] data;
            data = new String(user.getLogin()+" "+user.getPassword()+" "+user.getName()+" "+user.getRole()).getBytes();
            fos.write(data);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            return false;
        } catch (IOException e){
            System.err.println(e.getMessage());
            return false;
        } finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        String storageAddres = "f:\\Важное\\Java\\IDEA\\BelHard\\J2EEProfLvl\\Java\\RegAuthApp\\src\\main\\java\\by\\homework\\regauthapp\\storage\\usersdata\\";
        File file = new File(storageAddres);
        File[] listUser = file.listFiles();
        List<User> users = new ArrayList<>();
        String[] userData;
        for(int i=0;i<listUser.length;i++) {
            try (Stream<String> lines = Files.lines(Paths.get(listUser[i].getAbsolutePath()))){
                userData = lines.collect(Collectors.<String>toList()).get(0).split("\\s");
                if(userData[0].equals("admin")){
                    continue;
                }else
                users.add(new User(userData[0],userData[2],userData[1]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return users;
    }
}
