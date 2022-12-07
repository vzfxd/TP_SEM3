package pl.biblioteka.exception;

public class InvalidBook extends Exception{

    public InvalidBook (final String error)
    {
        super(error);
    }
}
