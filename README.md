# Project Title

Mancala

## Description

Users may play a text-based version of the boardgame Mancala with another player <br><br>

* Store:
    * setOwner() sets the owner of a store
    * getOwner() returns the owner of the store
    * addStones() adds either 1 or a number of stones to the store
    * getTotalStones() returns the total number of stones in the store
    * emptyStore() empties the store of all stones
    * toString() returns the number of stones as a string <br>
* Pit:
    * getStoneCount() returns the number of stones in the pit
    * addStone() adds one stone to the pit
    * removeStones() removes all stones from the pit
    * toString() returns the total number of stones as a string <br>
* Player:
    * setName() sets the name of the player
    * getName() gets the name of the player
    * setStore() sets the store of the player to a given store passed to the method
    * getStoreCount() gets the number of stones in a player's store
    * toString() returns the player name, number of stones in the store and player number as a string
    * setPlayerNumber() sets the player's number
    * getPlayerNumber() returns the player's number <br>
* Board: 
    * setUpPits() creates the pits and puts them into an arraylist
    * getPits() returns the pit arraylist
    * setUpStores() creates the stores and adds them to an arraylist
    * getStores() returns the stores arraylist
    * initializeBoard() empties the stores and sets the pits to have 4 stones each
    * resetBoard() resets the board before a new game
    * registerPlayers() assigns the players their store
    * moveStones() checks to make sure the move is in bounds
    * distributeStones() makes the player's move by distributing the stones in the pits
    * checkForCapture() helper method that makes sure the conditions of captureStones() is met
    * captures the stones on the opposite side of the board and adds it to the player's store
    * getNumStones() gets the number of stones in a pit
    * isSideEmpty() checks if the side is empty
    * tallySide() helper method to collect the stones on each side of the board at the end
    * toString() creates a string represention of the board <br>
* MancalaGame:
    * setPlayers() creates the players, assigns names, numbers and registers them
    * getPlayers() returns the players arraylist
    * getCurrentPlayer() returns the current player
    * changePlayer() changes the current player
    * setCurrentPlayer() sets the current player
    * setBoard() creates the board
    * getBoard() returns the current board
    * getNumStones returns the number of stones in a pit
    * move() checks if move is valid, calls moveStones()
    * totalSide() calculates the total number of stones on a player's side
    * getStoreCount() returns the total number of stones in a player's store
    * getWinner() retrieves the winner of the match
    * isGameOver() checks if the game is over
    * startNewGame() starts a new game with same players
    * boardLayout() returns a layout of the board before the game commences
    * whoseTurn() prompts the current player for their move
    * getWinnerName() retrieves the winner's name

## Getting Started

### Dependencies

* Default Java Libraries
* Array Lists
* Scanner
* Exceptions

### Executing program

* How to build and run the program
* Step-by-step bullets
```
run the gradle file with gradle build
use gradle echo to find the command
your choice of .jar file or class files

To run the program from jar:
java -jar build/libs/Mancala.jar
To run the program from class files:
java -cp build/classes/java/main ui.TextUI
```
* include the expected output
Player one enter your name:


## Limitations

Text-Based

## Development History

Keep a log of what things you accomplish when.  You can use git's tagging feature to tag the versions or you can reference commits.

* 0.9
    * moveStones now tells how many stones were added to a store
    * made the currentPlayer variable useful
    * added new method changePlayer()
* 0.8
    * changed board output to be in board class
    * made testcases in BoardTest
* 0.7
    * captureStones fixes
* 0.6 
    * Exceptions working
* 0.5
    * Added bonus turn feature
* 0.4
    * Winner and checkForCapture changes
* 0.3
    * fixes to distributeStones
* 0.2
    * Added required files
    * See [commit change]() or See [release history]()
* 0.1
    * Pushed code to gitlab

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [simple-readme] (https://gist.githubusercontent.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc/raw/d59043abbb123089ad6602aba571121b71d91d7f/README-Template.md)



