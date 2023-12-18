package mancala;

public class Player extends Object{

    private String playerName;
    private Store playerStore;

    private int playerNumber;

    public Player(){
        setName("");
        playerNumber = 0;
    }

    public Player(String name){
        setName(name);
        setPlayerNumber(0);
    }

    public Player(String name, int playerNum){
        setName(name);
        setPlayerNumber(playerNum);
    }

    public Player(String name, Store storeValue){
        setName(name);
        setStore(storeValue);
    }

    public void setName(String name){
        playerName = name;
    }

    public String getName(){
        return playerName;
    }

    void setStore(Store store){
        playerStore = store;
    }

    int getStoreCount(){
        return playerStore.getTotalStones();
    }

    Store getStore(){
        return playerStore;
    }

    public String toString(){
        String returnString = playerName + " " + getStoreCount() + " " + playerNumber;
        return returnString;
    }

    void setPlayerNumber(int playerNum){
        playerNumber = playerNum;
    }

    int getPlayerNumber(){
        return playerNumber;
    }

}