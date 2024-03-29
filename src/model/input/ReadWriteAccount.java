package model.input;

import model.entity.Account;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

public class ReadWriteAccount {
    private ArrayList<Account> listAccount;
    private final String SOURCE = "fileIO\\accounts.txt";
    private BufferedReader bufferedReader;
    private static ReadWriteAccount instance = null;

    private ReadWriteAccount() {
        listAccount = new ArrayList<>();
        this.readListUser();
    }

    public static ReadWriteAccount getInstance() {
        if (instance == null) {
            instance = new ReadWriteAccount();
        }
        return instance;
    }

    public void readListUser() {
        try {
            File file = new File(SOURCE);
            bufferedReader = Files.newBufferedReader(file.toPath(),
                    StandardCharsets.UTF_8);
            do{
                String[] str = bufferedReader.readLine().split("~");
                if (str.length>0) {
                    listAccount.add(new Account(str[0], str[1], str[2].equals("admin")));
                }
                else {
                    break;
                }
            }
            while (true);
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("\n");
        }
    }

    public void writeListUser() {
        try{
            PrintWriter pw = new PrintWriter(SOURCE);
            for (Account account : listAccount) {
                pw.println(account.getName() + "~" + account.getPass() + "~" + (account.getAdminAccount()?"admin":"user"));
            }
            pw.close();
        }catch(IOException ioe){
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }
    }

    public void addAccount(Account account) {
        listAccount.add(account);
    }

    public void editAccount(Account account) {
        for(Account account1 : listAccount) {
            if (account.getName().equals(account1.getName())) {
                account1.setPass(account.getPass());
                account1.setAdminAccount(account.getAdminAccount());
            }
        }
    }

    public void deleteAccount(String name) {
        for (int i=0; i<listAccount.size(); i++) {
            if (name.equals(listAccount.get(i).getName())) {
                listAccount.remove(i);
                break;
            }
        }
    }

    public int searchAccount(String name) {
        for (int i=0; i<listAccount.size(); i++) {
            if (listAccount.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Account> getListUser() {
        return listAccount;
    }
}
