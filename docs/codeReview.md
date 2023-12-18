# Meaningful method and variable names
My version of mancala had much more meaningful variable names compared to the version I got from ChatGPT. Taking the board as an example, I have both an arraylist for pits and stores allowing me to know exactly which one I am referencing when using them. The board in the version created by AI only has one array called board that contains both the pits and stores, it would be impossible to guess which elements of the array would be pits/stores without having it explained or seeing it get initialized. Futhermore, the AI verison uses a boolean variable titled playerTurn, although it is declared in a comment that when playerTurn is true that means it is player one's turn and false means it is player two's turn, without reading that comment it would be difficult to determine whose turn the variable signified. In my version of mancala, I included a boolean variable in my board class to keep track of turns although I had called it playerOneTurn, signifying that it denotes player one's turn.

# Does the code follow conventions?
The AI code includes useless imports such as the java.util.Arrays import as well as not making it's main function static which is bad form. My version of mancala has a static main method and only imports libraries it requires like ArrayLists and Scanner. Furthermore, the AI verison forgot to close the scanner when finished with it, which is bad form as well. I closed my scanner at the end of my code.

# Methods
Encapsulation was not needed for the AI code as it is all in one class, although it does not use any accessor or mutator methods which will make it clunky to work with as more code gets added. My code strictly uses only accessor and mutator methods when changing values of things like the currentPlayer, Player information, Pits and Stores. This allows me to only need to change one line of code when setting/getting a method is working incorrectly or needs to be changed speeding up the development process and making it much less complicated to read.

# Duplicate code
I could have found a better way to determine whose turn it was, I based the turn algorithm off of a boolean in the board class, then MancalaGame would check the value of it and set the current player based on that, these could be considered to do the same thing and be duplicate code. If I had thought harder about it I could have avoided performing the turn check this way. The AI verison did not have any duplicate code in it.

# Single Responsibility Principle
I tried to adhere as strictly as possible to the One Responsibility Principle, each of my methods are only responsible for doing one thing and are less than 50 lines each, this allows each method to be understood very easily and makes it easy to track down bugs inside the code.


# How does my program function better as an OO Program?
My program implements different classes for each part of the game, it has classes for: <br>
<ul>
    <li>Pits</li>
    <li>Stores</li>
    <li>Players</li>
    <li>Board</li>
    <li>Game Logic</li>
<ul>
<br>
While the AI code holds everything in the main class. Having the separate classes all link together is a good example of the OO concept aggregation. To keep the code as simple as possible I put the different methods for each part in their own class to then be referenced by the other classes when needed. Doing this keeps the code organized and easier to read. <br><br>
My code can have much more information associated with each object compared to the AI Code. For example, the AI code does not track anything to do with the player, aside from which side of the board they own as well as keeping both pits and stores stored together in one array. My code has a different approach, because each part of the game is an object, it can keep a lot more information, such as Player names and numbers as well as tracking which store belongs to each player. Furthermore my code keeps the pits and stores separated, allowing them to be referenced individually and avoiding mixups by direct referencing inside an array. <br><br>
My code utilizes good encapsulation. No class that is unauthorized is allowed to change board statistics, player information etc. This ensures that the game information is kept safe and cannot be changed, although since the AI version is all in one class, information can accidentially be changed by other methods. <br><br>
My code can be used with any TextUI as long as the methods are called in the proper context. Since the AI version is all stored in one class which means the code cannot be changed if you wish it to function in the same manner. 