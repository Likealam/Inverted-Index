package invertedindex.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class DocumentReader {
    static public Stream<String> read(File file) throws FileNotFoundException {
            Scanner scanner = new Scanner(file);
            return scanner.findAll("[\\p{IsAlphabetic}]{3,}").map(MatchResult::group).map(String::toLowerCase);
    }


}
