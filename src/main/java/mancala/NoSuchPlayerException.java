package mancala;

public class NoSuchPlayerException extends Exception{
    public NoSuchPlayerException(){
        System.out.println("Invalid player.");
    }
}
