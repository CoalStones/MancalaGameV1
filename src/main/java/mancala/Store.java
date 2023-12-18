package mancala;

public class Store extends Object{
    
    private Player owner;
    private int playerStore; // can i initialize here?


    public Store(){
        playerStore = 0;
    }

    void setOwner(Player player){
        owner = player;
    }

    Player getOwner(){
        return owner;
    }

    void addStones(){
        playerStore++;
    }

    void addStones(int amount){
        playerStore += amount;
    }

    int getTotalStones(){
        return playerStore;
    }

    int emptyStore(){
        int temp = playerStore;
        playerStore = 0;
        return temp;
    }

    @Override
    public String toString(){
        String returnString = String.valueOf(playerStore);
        return returnString;
    }
}