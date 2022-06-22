package invertedindex;

import invertedindex.file.DocumentReader;
import invertedindex.model.Document;
import invertedindex.model.TermDetails;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RankTable {
    private String sourcePath;
    private Map<String, TermDetails> table = new HashMap<>();
    private Set<Document> documents = new HashSet<>();
    public RankTable(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    private void readFiles(File directory) {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                readFiles(file);
                continue;
            }
            Document document = new Document(file);
            if(!documents.add(document)){
                continue;
            }
            try (Stream<String> text = DocumentReader.read(file)) {

                text.forEach((word) -> {
                    if (!table.containsKey(word)) {
                        table.put(word, new TermDetails());
                    }
                    table.get(word).addDocument(document);
                });
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            }
        }
    }

    void readFiles() {
        File file = new File(sourcePath);
        readFiles(file);
    }

    public Set<Map.Entry<String, TermDetails>> formSortedTable() {
        TreeSet<Map.Entry<String, TermDetails>> sortedTable = new TreeSet<>(
                (term1, term2) -> {
                    int indexCompare = Double.compare(term1.getValue().getIndex(), term2.getValue().getIndex());
                    if (indexCompare == 0) {
                        return String.CASE_INSENSITIVE_ORDER.compare(term1.getKey(), term2.getKey());
                    }
                    return -indexCompare;
                });
        sortedTable.addAll(table.entrySet());
        return sortedTable;
    }
}
