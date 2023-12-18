package mancala;

public class GameNotOverException extends InvalidMoveException{
    public GameNotOverException(){
        System.out.println("The game is not over yet.");
    }
}
