package model.input;

import model.entity.Service;

import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

public class ReadService {
    private ArrayList<Service> listService;
    private final String SOURCE = "fileIO\\service.txt";
    private BufferedReader bufferedReader;
    private static ReadService instance = null;

    private ReadService() {
        listService = new ArrayList<>();
        this.readAllService();
    }

    public static ReadService getInstance() {
        if (instance== null) {
            instance = new ReadService();
        }
        return instance;
    }

    public void readAllService() {
        try {
            File file = new File(SOURCE);
            bufferedReader = Files.newBufferedReader(file.toPath(),
                    StandardCharsets.UTF_8);
            do{
                String[] str = bufferedReader.readLine().split("~");
                if (str.length>0) {
                    listService.add(new Service(str[0], Integer.parseInt(str[1])));
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

    public Service getServiceByName(String name) {
        for (Service service:listService) {
            if (service.getName().equals(name)) {
                return service;
            }
        }
        return null;
    }

    public String[] getListServiceName() {
        String[] arrayName = new String[listService.size()];
        for (int i=0; i<listService.size(); i++) {
            arrayName[i] = listService.get(i).getName();
        }
        return arrayName;
    }
}
