package exceptions;

/**
 * Created by Lukas on 24-5-2017.
 */
public class PacketException extends Exception {

    private static final long serialVersionUID=1L;
    public PacketException() {}

    public PacketException(String message, Throwable exception){
        super(message, exception);
    }

    public PacketException(String message)
    {
        super(message);
    }

    public PacketException(Throwable exception){
        super (exception);
    }
}
