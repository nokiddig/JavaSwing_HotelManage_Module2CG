package fileReadWrite;

import model.entity.Account;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

public class ReadWriteAccount {
    private ArrayList<Account> listAccount = new ArrayList<>();
    private final String src = "fileIO\\accounts.txt";
    private BufferedReader bufferedReader;

    public ReadWriteAccount() {
        readListUser();
    }

    public void readListUser() {
        try {
            File file = new File(src);
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
        } catch (Exception e) {
            System.out.println("Read admin account fail!");
        }
    }
    public void writeListUser() {
        try{
            PrintWriter pw = new PrintWriter(src);
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
        writeListUser();
    }

    public void editAccount(Account account) {
        for(Account account1 : listAccount) {
            if (account.getName().equals(account1.getName())) {
                account1.setPass(account.getPass());
            }
        }
        writeListUser();
    }

    public void deleteAccount(Account account) {
        for (int i=0; i<listAccount.size(); i++) {
            if (account.getName().equals(listAccount.get(i).getName())) {
                listAccount.remove(i);
                break;
            }
        }
        writeListUser();
    }

    public ArrayList<Account> getListUser() {
        return listAccount;
    }
}
