package mancala;

public class InvalidMoveException extends Exception{
        public InvalidMoveException(){
            System.out.println("Invalid move.");
        }

        public InvalidMoveException(String output){
            System.out.println(output);
        }
}
