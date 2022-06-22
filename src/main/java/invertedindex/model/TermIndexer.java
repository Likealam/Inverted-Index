package invertedindex.model;

import invertedindex.exception.IndexPropertiesNotFoundException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Map;
import java.util.Properties;

public class TermIndexer {

    static double k1;
    static double k2;
    static double k3;
    static {
        loadProperties();
    }

    public static void loadProperties() {
        File file = new File("src/main/resources/properties/indexer.properties");
        try(FileReader fileReader = new FileReader(file)) {
            Properties properties = new Properties();
            properties.load(new FileReader(file));
            k1 = Double.parseDouble(properties.getProperty("k1"));
            k2 = Double.parseDouble(properties.getProperty("k2"));
            k3 = Double.parseDouble(properties.getProperty("k3"));

        } catch (IOException e) {
            throw new IndexPropertiesNotFoundException(e);
        }
    }
    private static double  logarithm(double a,double b){
        return Math.log(b)/Math.log(a);
    }
    public static double getIndex(Document document, int count) {
        return k1 * document.getSize() + logarithm(k2,count) +
                1 / logarithm (k3, Instant.now().toEpochMilli() - document.getLastModified());
    }
    public static double getIndex(Map.Entry<Document, Integer> entry) {
        return getIndex(entry.getKey(), entry.getValue());
    }
}
