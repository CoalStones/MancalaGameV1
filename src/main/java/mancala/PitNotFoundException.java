package mancala;

public class PitNotFoundException extends Exception{
    public PitNotFoundException(){
        super("Pit not found. Invalid placement.");
    }

    public PitNotFoundException(String output){
        super(output);
    }
}
