package view;

public class OutOfRangeException extends Exception {
    public OutOfRangeException(){
        super("Option out of range. Please choose a correct option");
    }
}