package exception;

public class Exception extends RuntimeException{

    private static final Long serialVersionUID = 1L;

    public Exception(String msg) {
        super(msg);
    }
}
