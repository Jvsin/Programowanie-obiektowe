public class EmptyMessageException extends Exception{
    public EmptyMessageException() {
        super("Wiadomość jest pusta");
    }
}
