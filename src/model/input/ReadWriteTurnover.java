package model.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ReadWriteTurnover {
    private final String SOURCE = "fileIO\\turnover.txt";
    private long turnOver = 0;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private static ReadWriteTurnover instance = null;

    private ReadWriteTurnover() {
        this.readTurnover();
    }

    public static ReadWriteTurnover getInstance() {
        if (instance == null) {
            instance = new ReadWriteTurnover();
        }
        return instance;
    }
    private void readTurnover() {
        File file = new File(SOURCE);
        try {
            bufferedReader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);
            turnOver = Integer.parseInt(bufferedReader.readLine());
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeTurnover() {
        try{
            printWriter = new PrintWriter(SOURCE);
            printWriter.print(turnOver);
            printWriter.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public long getTurnOver() {
        return turnOver;
    }

    public void setTurnOver(long turnOver) {
        this.turnOver = turnOver;
    }
}
