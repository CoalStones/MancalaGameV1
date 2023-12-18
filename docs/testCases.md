| Method | Case | Entered Value | Expected | Pass/Fail |
| --- | --- | --- | --- | --- |
| distributeStones | Entered number is too high | 13 | PitNotFoundException | Passes |
| distributeStones | Entered number is too low | -1 | PitNotFoundException | Passes |
| distributeStones | Moves stones from P1 side | 0 | 4 | Passes |
| distributeStones | Moves stones from P1 side | 3 | 4 | Passes |
| distributeStones | Moves stones from P1 side | 5 | 4 | Passes |
| distributeStones | Moves stones from P2 side | 6 | 4 | Passes |
| distributeStones | Moves stones from P2 side | 8 | 4 | Passes |
| distributeStones | Moves stones from P2 side | 11 | 4 | Passes |
| captureStones | Captures stones from opposite side of the board | 0 | 8 | Passes |
| captureStones | Captures stones from opposite side of the board | 5 | 8 | Passes |
| captureStones | Captures stones from opposite side of the board | 6 | 8 | Passes |
| captureStones | Captures stones from opposite side of the board | 11 | 8 | Passes |
| captureStones | Captures stones from opposite side of the board | 3 | 8 | Passes |
| getNumStones | Gets the number of stones from a defined pit | 13 | PitNotFoundException | Passes |
| getNumStones | Gets the number of stones from a defined pit | -1 | PitNotFoundException | Passes |
| getNumStones | Gets the number of stones from a defined pit | 5 | 4 | Passes |
| getNumStones | Gets the number of stones from a defined pit after distribution | 11 | 5 | Passes |
| isSideEmpty | Checks if the side is empty | 13 | PitNotFoundException | Passes |
| isSideEmpty | Checks if the side is empty | 0 (with full side) | false | Passes |
| isSideEmpty | Checks if the side is empty | 4 (with full side) | false | Passes |
| isSideEmpty | Checks if the side is empty | 5 (with full side) | false | Passes |
| isSideEmpty | Checks if the side is empty | 6 (with full side) | false | Passes |
| isSideEmpty | Checks if the side is empty | 8 (with full side) | false | Passes |
| isSideEmpty | Checks if the side is empty | 11 (with full side) | false | Passes |
| isSideEmpty | Checks if the side is empty | 4 (with empty side) | true | Passes |
| isSideEmpty | Checks if the side is empty | 8 (with empty side) | true | Passes |
| resetBoard | resets each pit to have 4 stones and each store to have 0 | isSideEmpty (After emptying the side and resetting the board) | false | Passes |
| registerPlayers | Sets the players stores | playerOnePit | 0 | Passes |
| registerPlayers | Sets the players stores | playerOnePit | 0 | Passes |