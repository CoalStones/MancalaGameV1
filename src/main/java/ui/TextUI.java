package ui;

import java.util.Scanner;

import mancala.PitNotFoundException;
import mancala.InvalidMoveException;

import mancala.MancalaGame;
import mancala.Player;


public class TextUI {
    
    public static void main(String[] args) throws PitNotFoundException{
        MancalaGame game = new MancalaGame();
        Scanner userInput = new Scanner(System.in);
        char newGame;
        String nameGrabber;
        Player playerOne = new Player();
        Player playerTwo = new Player();

        System.out.println("Enter your name player one");
        nameGrabber = userInput.nextLine();
        playerOne.setName(nameGrabber);
        System.out.println("Enter your name player two");
        nameGrabber = userInput.nextLine();
        playerTwo.setName(nameGrabber);
        game.setPlayers(playerOne, playerTwo);

        System.out.println("Player One's name is: " + playerOne.getName());

        System.out.println(game.boardLayout());

        while(true){
            try{
                do{
                    while(!game.isGameOver()){
                        System.out.println(game.toString());
                        
                        // currentPlayer = game.getCurrentPlayer();
                        // game.setCurrentPlayer(currentPlayer);

                        System.out.println("Which pit would you like to play from "+ game.getCurrentPlayerName() + "?");

                        System.out.println(game.getCurrentPlayerName() + " has "+game.move(userInput.nextInt()) 
                                           + " stones left on their side");
                    }
                    
                    do{
                        System.out.println("Would you like to play again? y/n");
                        newGame = userInput.next().charAt(0);
                    }while(newGame != 'y' && newGame != 'n');
                    game.startNewGame();
                }while(newGame == 'y');
                break;
            } catch(InvalidMoveException err){
                //err = new InvalidMoveException("That is not a valid choice");
            }
        }

        userInput.close();

    }
}
