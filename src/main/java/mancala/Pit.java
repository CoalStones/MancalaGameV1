package mancala;

public class Pit extends Object{

    private int stones;

    public Pit(){
        stones = 0;
    } // I don't think we need to start a pit with stones

    /**
     * Returns the number of stones in the pit
     */
    int getStoneCount(){
        return stones;
    }

    /**
     * Adds a stone to the pit
     */
    void addStone(){
        stones++;
    }

    /**
     * Removes a stone from the pit
     */
    int removeStones(){
        int total = stones;
        stones = 0;
        return total;
    }

    @Override
    public String toString(){
        String returnString = String.valueOf(stones);
        return returnString;
    }

}