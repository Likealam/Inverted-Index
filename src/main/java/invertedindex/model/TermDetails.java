package invertedindex.model;


import java.io.File;
import java.util.*;


public class TermDetails {
    private final Map<Document, Integer> entriesToFile = new HashMap<>();


    public void addDocument(Document document) {
        entriesToFile.merge(document, 1, Integer::sum);
    }

    public Set<Document> getIndexedFileEntries() {
        Set<Document> set = new TreeSet<>((document1,document2)->{
            int indexCompare = Double.compare(TermIndexer.getIndex(document1,entriesToFile.get(document1)),TermIndexer.getIndex(document2,entriesToFile.get(document2)));
            if(indexCompare==0){
                return document1.getName().compareTo(document2.getName());
            }
            return -indexCompare;
        });
        set.addAll(entriesToFile.keySet());
        return set;
    }


    public double getIndex() {
        double sum = 0;
        for (Map.Entry<Document, Integer> entry : entriesToFile.entrySet()) {
            sum += TermIndexer.getIndex(entry);
        }
        return sum;
    }
}
