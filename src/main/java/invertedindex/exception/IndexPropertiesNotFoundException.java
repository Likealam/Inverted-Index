package invertedindex.exception;

public class IndexPropertiesNotFoundException extends RuntimeException{
    IndexPropertiesNotFoundException(){
        super("Index properties file not found");
    }
    public IndexPropertiesNotFoundException(Throwable cause){
        super("Index properties file not found",cause);
    }
}
