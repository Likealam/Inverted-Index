package invertedindex.model;


import java.io.File;
import java.util.Objects;

public class Document {

    private String name;
    private long size;
    private long lastModified;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document)) return false;
        Document document = (Document) o;
        return size == document.size && Objects.equals(name, document.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }

    public Document(String name, long size, long lastModified) {
        this.name = name;
        this.size = size;
        this.lastModified = lastModified;
    }

    public Document(File file) {
        this(file.getName(), file.length(), file.lastModified());
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public long getLastModified() {
        return lastModified;
    }


}
