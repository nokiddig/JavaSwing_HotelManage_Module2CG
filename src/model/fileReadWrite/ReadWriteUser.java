package model.fileReadWrite;

import model.entity.User;

import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

public class ReadWriteUser {
    private ArrayList<User> listUser = new ArrayList<User>();
    private String src = "fileIO\\Account\\fileAdmin.txt";
    private BufferedReader bufferedReader;
    private File file;

    public ReadWriteUser() {
        readListUser();
    }

    public void readListUser() {
        try {
            File file = new File(src);

            bufferedReader = Files.newBufferedReader(file.toPath(),
                    StandardCharsets.UTF_8);
            do{
                String name = bufferedReader.readLine();
                String pass = bufferedReader.readLine();
                if (name != null && pass != null) {
                    User user = new User(name, pass, true);
                    listUser.add(user);
                }
                else {
                    break;
                }
            }
            while (true);
        } catch (Exception e) {
            System.out.println("Read admin account fail!");
            e.printStackTrace();
        }
    }

    public void writeListUser() {

    }

    public ArrayList<User> getListUser() {
        return listUser;
    }
}
