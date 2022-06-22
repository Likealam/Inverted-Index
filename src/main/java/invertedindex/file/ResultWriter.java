package invertedindex.file;

import invertedindex.model.Document;
import invertedindex.model.TermDetails;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ResultWriter {
    static public void write(Set<Map.Entry<String, TermDetails>> sortedTable) {
        File file = new File("src/main/resources/result/result.txt");
        File directory = new File("src/main/resources/result");
        try {
            directory.mkdirs();
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(file, false)) {
            int maxLength = sortedTable.stream().max(Comparator.comparingInt(str -> str.getKey().length())).get().getKey().length();
            for (Map.Entry<String, TermDetails> term : sortedTable) {
                String word = term.getKey();
                fileWriter.write(word+" ".repeat(maxLength-word.length())+"| ");
                String documents = term.getValue()
                        .getIndexedFileEntries()
                        .stream()
                        .map(Document::getName)
                        .collect(Collectors.joining(", "));
                fileWriter.write(documents + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
