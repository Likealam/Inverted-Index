package invertedindex;

import invertedindex.file.ResultWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {
        try {
            File directory = new File("src/main/resources/log");
            directory.mkdirs();
            System.setErr(new PrintStream("src/main/resources/log/main.log"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(args.length<1){
            throw new IllegalArgumentException("Path argument required!");
        }
        RankTable rankTable = new RankTable(args[0]);
        rankTable.readFiles();
        ResultWriter.write(rankTable.formSortedTable());
    }

}
