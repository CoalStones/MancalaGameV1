package mancala;

import java.util.ArrayList;

public class Board extends Object{

    private ArrayList<Pit> pits; // should have 12 (6 per player)
    private ArrayList<Store> stores; // should have 2

    private boolean playerOneTurn;
    
    public Board(){
        pits = new ArrayList<>();
        stores = new ArrayList<>();
        setUpPits();
        setUpStores();
        initializeBoard();
        playerOneTurn = true;
    }
    /**
     * Creates pits for both players
     * needs to be an arrayList i think
     * based off the getPits() method
     */
    void setUpPits(){
        for(int i = 0; i < 12; i++){
            pits.add(new Pit());
        }
    }

    /**
     * Returns the pits
     */
    ArrayList<Pit> getPits(){
        return pits;
    }

    /**
     * Sets up the stores
     */
    void setUpStores(){
        stores.add(new Store());
        stores.add(new Store());
    }

    /**
     * Returns the stores
     */
    ArrayList<Store> getStores(){
        return stores;
    }

    /**
     * Initializes the board
     * Only distributes stones
     * Stores start with 0 stones
     * Pits start with 4 stones
     */
    void initializeBoard(){
        for(Store i: stores){
            i.emptyStore();
        }
        for(Pit i: pits){ // iterates through every pit
            while(i.getStoneCount() != 4){
                if(i.getStoneCount() < 4){ // not enough stones
                    i.addStone();
                } else{ // too many stones
                    i.removeStones();
                }
            }
        }
    }

    /**
     * Returns the board to 4 stones per pit and 0 in the store
     */
    void resetBoard(){
        playerOneTurn = true;
        initializeBoard();
    }

    /**
     * Registers the players with stores
     * @param one
     * @param two
     */
    void registerPlayers(Player one, Player two){
        one.setStore(stores.get(0)); // not sure if this will work
        stores.get(0).setOwner(one);
        two.setStore(stores.get(1));
        stores.get(1).setOwner(two);
    }

    /**
     * This method should only be passing the starting pit to the distribute stones
     * @param startPit
     * @param player
     * @return
     */
    int moveStones(int startPit, Player player) throws InvalidMoveException{

        if(startPit < 0 || startPit > 12){
            throw new InvalidMoveException();
        }else if((startPit > 6 || startPit < 0) && player.getPlayerNumber() == 1){
            throw new InvalidMoveException();
        } else if((startPit > 12 || startPit < 7) && player.getPlayerNumber() == 2){
            throw new InvalidMoveException();
        }

        try{
            int numOfStones = player.getStoreCount();

            distributeStones(startPit - 1);

            numOfStones = player.getStoreCount() - numOfStones;
            return numOfStones;
        } catch (PitNotFoundException err){
            //System.out.println(err);
            err = new PitNotFoundException();
            return -1;
        }
    }
    
    /**
     * Distributes the stones throughout the arrayList
     * @param startingPoint
     * @return
     */
    public int distributeStones(int startingPoint) throws PitNotFoundException{
        boolean justPlacedPit = false; 
        int pitPlacement = startingPoint + 1; // we're not placing in the pit we just took from
        if(pitPlacement > 12 || pitPlacement <= 0){
            throw new PitNotFoundException();
        }
        int stonesToPlace = pits.get(startingPoint).removeStones();
        int totalPlaced = stonesToPlace;
        if(pitPlacement == 12){
            pitPlacement = 0;
        }
        if(startingPoint >= 6){
            playerOneTurn = false;
        }
        while(stonesToPlace > 0){
            //System.out.println(stonesToPlace + " " + pitPlacement + " " + playerOneTurn + " " + justPlacedPit);
            if(playerOneTurn){
                if(pitPlacement == 6 && !justPlacedPit){
                    stores.get(0).addStones();
                    justPlacedPit = true;
                } else{
                    if(pitPlacement == 11){ // player 2's pit
                        pitPlacement = 0;
                    }
                    pits.get(pitPlacement).addStone();
                    justPlacedPit = false;
                    pitPlacement++;
                }
            } else{ // player 2
                if(pitPlacement == 0 && !justPlacedPit){
                    stores.get(1).addStones();
                    justPlacedPit = true;
                } else{
                    pits.get(pitPlacement).addStone();
                    if(pitPlacement == 11){
                        pitPlacement = -1;
                    }
                    justPlacedPit = false;
                    pitPlacement++;
                }
            }
            stonesToPlace--;
        }
        if(justPlacedPit){
            playerOneTurn = !playerOneTurn;
        }
        totalPlaced += checkForCapture(pitPlacement-1);
        playerOneTurn = !playerOneTurn;
        return totalPlaced;
    }

    /**
     * My own function to check if we need to capture the stones
     * @param pitPlacement
     * @param playerOneTurn
     */
    int checkForCapture(int pitPlacement)throws PitNotFoundException{
        //System.out.println(pitPlacement + " " + playerOneTurn + " " + pits.get(pitPlacement).getStoneCount());
        int capturedStones = 0;
        try{
            if(pitPlacement == -1 && !playerOneTurn && pits.get(11).getStoneCount() == 1){
                capturedStones = captureStones(11);
                stores.get(1).addStones(capturedStones);
            } else if(pitPlacement >= 0 && pitPlacement <= 5 && playerOneTurn 
                      && pits.get(pitPlacement).getStoneCount() == 1){
                capturedStones = captureStones(pitPlacement);
                stores.get(0).addStones(capturedStones);
            } else if(pitPlacement >= 6 && pitPlacement <= 11 && !playerOneTurn 
                      && pits.get(pitPlacement).getStoneCount() == 1){
                capturedStones = captureStones(pitPlacement);
                stores.get(1).addStones(capturedStones);
            }
            return capturedStones;
        } catch (PitNotFoundException err){
            throw new PitNotFoundException();
        }
    }

    /**
     * this works but i don't know how i should call it
     */
    int captureStones(int stoppingPoint)throws PitNotFoundException{
        //System.out.println("This function was called");
        
        if(stoppingPoint > 11 || stoppingPoint < 0){
            throw new PitNotFoundException();
        }

        int oppositeSide = 11 - stoppingPoint;
        
        int totalStones = 0;

        totalStones += pits.get(stoppingPoint).removeStones();
        totalStones += pits.get(oppositeSide).removeStones();

        return totalStones;
    }

    int getNumStones(int pitNum) throws PitNotFoundException{
            if(pitNum > 12 || pitNum < 0){
                throw new PitNotFoundException();
            }
            int stoneCount = pits.get(pitNum).getStoneCount();
            return stoneCount;
    }

    boolean isSideEmpty(int pitNum) throws PitNotFoundException{
        if(pitNum >= 0 && pitNum <= 5){
            pitNum = 0;
        } else if(pitNum >= 6 && pitNum <= 11){
            pitNum = 6;
        } else{
            throw new PitNotFoundException();
        }
        try{
            int total = 0;
            //System.out.println("Counting pits " + pitNum + " to " + (pitNum + 5));
            for(int i = pitNum; i <= pitNum+5; i++){
                total += getNumStones(i);
            }
            //System.out.println("Is the side empty? " + !(total > 0));
            return !(total > 0);
        } catch (PitNotFoundException err){
            throw new PitNotFoundException();
        }
    }


    void tallySide(){
        for(int i = 0; i < 6; i++){
            stores.get(0).addStones(pits.get(i).removeStones());
        }
        for(int i = 6; i < 12; i++){
            stores.get(1).addStones(pits.get(i).removeStones());
        }
    }

    @Override
    public String toString(){
        try{
            String board = "";

            board += "\n\t";
            for(int i = 11; i >= 6; i--){
                board += getNumStones(i);
                board += "\t";
            }
            board += "\n";

            board += stores.get(1).getTotalStones();
            board += "\t \t \t \t \t \t \t";
            board += stores.get(0).getTotalStones();
            board += "\n";

            board += "\t";
            for(int i = 0; i <= 5; i++){
                board += getNumStones(i);
                board += "\t";
            }
            board += "\n\n\n";

            return board;
        } catch(PitNotFoundException err){
            err = new PitNotFoundException();
            return "";
        }
    }

    public int getStoreCount(int whichStore){
        return stores.get(whichStore).getTotalStones();
    }

    public boolean whichPlayersTurn(){
        return playerOneTurn;
    }

}