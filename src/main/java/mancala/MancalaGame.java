package mancala;

import java.util.ArrayList;

public class MancalaGame extends Object{

    private ArrayList<Player> players;

    private Board mancalaBoard;

    private Player currentPlayer;

    /**
     * Constructor
     */
    public MancalaGame(){
        setBoard(new Board());
        players = new ArrayList<Player>();
    }

    /**
     * I think this is only supposed to set names
     * SET THE BOARD BEFORE THE PLAYERS
     */
    public void setPlayers(Player onePlayer, Player twoPlayer){
        onePlayer.setPlayerNumber(1);
        players.add(onePlayer);

        twoPlayer.setPlayerNumber(2);
        players.add(twoPlayer);

        mancalaBoard.registerPlayers(players.get(0), players.get(1));

        setCurrentPlayer(onePlayer);
    }

    /**
     * Returns the arraylist of players
     */
    public ArrayList<Player> getPlayers(){
        return players;
    }

    /**
     * returns the current player
     */
    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    /**
     * sets the current player
     */
    public void setCurrentPlayer(Player player){
        currentPlayer = player;
    }

    private void changePlayer(){
        if(mancalaBoard.whichPlayersTurn()){
            setCurrentPlayer(players.get(0));
        } else{
            setCurrentPlayer(players.get(1));
        }
    }

    /**
     * creates the board object for this class
     * SET THE BOARD BEFORE THE PLAYERS
     */
    public void setBoard(Board theBoard){
        mancalaBoard = theBoard;
        mancalaBoard.setUpStores();
        mancalaBoard.setUpPits();
        mancalaBoard.initializeBoard();
    }

    /**
     * returns the playing board
     */
    public Board getBoard(){
        return mancalaBoard;
    }

    /**
     * returns the number of stones in a certain pit
     */
    public int getNumStones(int pitNum) throws PitNotFoundException{
        return mancalaBoard.getNumStones(pitNum);
    }

    /**
     * counts the number of stones the player has left
     * Throws illegal player exception if player 1 tried to play on player 2 or vise versa
     * TODO add the exception + visibility
     */
    public int move(int startPit) throws InvalidMoveException{ // check on this PLEASE
        
        int totalStones = 0;
        try{
            if(mancalaBoard.getNumStones(startPit - 1) == 0){
                throw new InvalidMoveException();
            }
            System.out.println(mancalaBoard.moveStones(startPit, currentPlayer) 
                               + " stones were placed in a store that turn");
            totalStones = totalSide(getCurrentPlayer());
            changePlayer();
            return totalStones;
        } catch (InvalidMoveException err){
            //throw new InvalidMoveException();
        } catch (PitNotFoundException err){
            throw new InvalidMoveException();
        }
        Player tempCurrentPlayer = currentPlayer;
        changePlayer();
        return totalSide(tempCurrentPlayer);
    }

    int totalSide(Player player){
        int totalStones = 0;

        try{
            if(player.getPlayerNumber() == 1){
                for(int i = 0; i < 6; i++){
                    totalStones += mancalaBoard.getNumStones(i);
                }
            } else{
                for(int i = 6; i <= 11; i++){
                    totalStones += mancalaBoard.getNumStones(i);
                }
            }

            return totalStones;
        } catch(PitNotFoundException err){
            err = new PitNotFoundException();
        }
        return 0;
    }

    /**
     * returns the store count of the player
     */
    public int getStoreCount(Player player){
        return player.getStoreCount();
    }

    /**
     * Finds and returns the winner
     */
    public Player getWinner() throws GameNotOverException{
        if(!isGameOver()){
            throw new GameNotOverException();
        }
        //System.out.println("In the getWinner method");
        if(players.get(0).getStoreCount() > players.get(1).getStoreCount()){
            System.out.println("Player One Won");
            return players.get(0);
        } else if(players.get(0).getStoreCount() < players.get(1).getStoreCount()){
            System.out.println("Player Two Won");
            return players.get(1);
        } else{
            System.out.println("It was a Draw!");
            return null; // this has to be NULL
        }
    }

    /**
     * Checks to see if the game should be over
     */
    public boolean isGameOver(){
        
        try{
            boolean endTheGame = false;
            if(mancalaBoard.isSideEmpty(0) || mancalaBoard.isSideEmpty(6)){
                endTheGame = true;
            }

            if(endTheGame){
                mancalaBoard.tallySide();
            }

            return endTheGame;

        } catch (PitNotFoundException err){
            System.out.println(err.getMessage());
        }

        return false;
        
    }

    public void startNewGame(){
        setCurrentPlayer(players.get(0));
        mancalaBoard.resetBoard();
    }

    @Override
    public String toString(){

        return mancalaBoard.toString();
        
    }

    /**
     * Might have to delete this function later
     * All helper functions defined below this
     * @return
     */
    public String boardLayout(){
        String board = "";

        board += "\n\t";
        for(int i = 12; i >= 7; i--){
            board += i;
            board += "\t";
        }
        board += "\n";

        board += players.get(1).getStoreCount();
        board += "\t \t \t \t \t \t \t";
        board += players.get(0).getStoreCount();
        board += "\n";

        board += "\t";
        for(int i = 1; i <= 6; i++){
            board += i;
            board += "\t";
        }
        board += "\n\n\n";

        return board;
    }

    public void whoseTurn(){
        if(mancalaBoard.whichPlayersTurn()){
            System.out.println("Which pit would you like to play from "+ players.get(0).getName() + "?");
        } else{
            System.out.println("Which pit would you like to play from "+ players.get(1).getName() + "?");
        }
    }

    public String getCurrentPlayerName(){
        return currentPlayer.getName();
    }

}
