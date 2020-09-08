
public class KQueens {

    //Use these constants in your code
    final static int QUEEN = 1;
    final static int WALL = -1;
    final static int EMPTY = 0;


     /**
     * Checks if the input parameters are valid
     *
     * @param k number of queens
     * @param rows number of rows to be on a board
     * @param cols number of columns to be on a board
     * @param walls locations of walls on a board
     * @return true if all parameters are valid, false otherwise.
     */
    
    public static boolean isValidInput(int k, int rows, int cols, int[][] walls) {
    	
    	boolean isValid = true;
        if ((rows < 1 | cols < 1 | k < 1 | walls == null) || walls.length != rows) {
            isValid = false;
        }

        int wallsCounter = 0;
        for (int i = 0; isValid && i < walls.length; i = i +1) {
            if (walls[i] == null) {
                isValid = false;
            }
            else {
                for (int j= 0;isValid & j < walls[i].length; j = j + 1) {
                    if (walls[i][j] >= cols) { //Check if all parameters in walls are within the board
                        isValid = false;
                    }
                    wallsCounter = wallsCounter + 1;
                }
            }
        }
        if (k > ((rows * cols) - wallsCounter)) { //Check if number of queens doesn't exceed the number of empty spaces
            isValid = false;
        }

        return isValid;
    }

     /**
     * Creates a board of size rows x cols with walls
     *
     * @param rows number of rows in board. Assume valid value.
     * @param cols number of columns in board. Assume valid value.
     * @param walls locations of walls on board. Assume valid value.
     * @return rows x cols board with walls
     */
    
    public static int[][] createBoard(int rows, int cols, int[][] walls) {
    	
    	int[][] board = new int[rows][cols];
        for (int i = 0; i < board.length; i = i + 1) { //Find all wall coordinates and insert into wall
            for (int j = 0; j < walls[i].length; j = j + 1) {
                board[i][walls[i][j]] = WALL;
            }
        }

        return board;
    }

     /**
     * Print the representation of a board with queens and walls
     *
     * @param board to be printed. Assume valid value.
     */
    
    public static void printBoard(int[][] board) { //Scan and print the board coordinates

    	if (board.length != 0) {
            for (int i = 0; i < board.length; i = i + 1) {
                for (int j = 0; j < board[i].length; j = j + 1) { //Print new sign in the relevant place
                    if (board[i][j] == EMPTY) {
                        System.out.print("* ");
                    } else if (board[i][j] == QUEEN) {
                        System.out.print("Q ");
                    } else if (board[i][j] == WALL) {
                        System.out.print("X ");
                    }
                }
                System.out.println();
            }
        }
        else {
            System.out.println("There is no solution");
        }
    }

     /**
     * Validate that the walls in board match the walls locations in walls
     *
     * @param walls locations of walls in board. Assume valid value.
     * @param board a board with walls
     * @return true if walls on boards match the walls locations, false otherwise
     */
    
    public static boolean validateWalls(int[][] walls, int[][] board) {

    	boolean isValid = true;
    	
    	//Check if board is a valid input
    	if (board == null) {
    		isValid = false;
    	}
    	else {
    		for (int i = 0; isValid & i < board.length; i = i + 1)
    		{
    			if (board[i] == null) {
    				isValid = false;
    			}
    			else if (board[i].length != board[0].length) {
    				isValid = false;
    			}
    			else {
    				for (int j = 0; isValid & j < board[i].length; j = j + 1) {
    					if (board[i][j] != WALL & board[i][j] != EMPTY & board[i][j] != QUEEN) {
    					isValid = false;
    					}
    				}
    			}
    		}
    	}
    	//Check if board is a valid input - End

    	//Check if all walls on board appear in the wall matrix
        for (int i = 0; isValid & i < walls.length; i = i +1) {
            for (int j = 0; isValid & j < walls[i].length; j = j +1) {
                if (board[i][walls[i][j]] != WALL) {
                    isValid = false;
                }
            }
        }
        //Check if all walls on board appear in the wall matrix - End

        //Check if all walls appear in the board matrix
        for (int i = 0; i < board.length; i = i + 1) {
            for (int j = 0; j < board[i].length; j = j +1) {
                if (board[i][j] == WALL) {
                    isValid = false;
                    for (int k = 0; !isValid & k < walls[i].length; k = k + 1) {
                        if (walls[i][k] == j) {
                            isValid = true;
                        }
                    }
                }
            }
        }
        //Check if all walls appear in the board matrix - End
        
        return isValid;
    }



     /**
     * Check if the queen located in board[row][col] is threatened by another queen on the board
     *
     * @param board a queen is located on this board
     * @param row the row in which the queen is located
     * @param col the column in which the queen is located
     * @return true if queen is threatened, false otherwise
     */
    
    public static boolean isQueenThreatened(int[][] board, int row, int col) {
    	boolean isThreatened = false;
        int i;
        int j;

        i = row + 1;
        while (!isThreatened & i < board.length && board[i][col] != WALL) { //Check if queen is threatened by a queen below the queen's spot
            if (board[i][col] == QUEEN) {
                isThreatened = true;
            }
            i = i +1;
        }
        i = row - 1;
        while (!isThreatened & i >= 0 && board[i][col] != WALL) { //Check if queen is threatened by a queen above the queen's spot
            if (board[i][col] == QUEEN) {
                isThreatened = true;
            }
            i = i - 1;
        }

        i = row;
        j = col + 1;
        while (!isThreatened & j < board[row].length && board[row][j] != WALL) { //Check if queen is threatened by a queen to the right of the queen spot
            if (board[row][j] == QUEEN) {
                isThreatened = true;
            }
            j = j + 1;
        }
        
        j = col - 1;
        while (!isThreatened & j >= 0 && board[row][j] != WALL) { //Check if queen is threatened by a queen to the left of the queen spot
            if (board[row][j] == QUEEN) {
                isThreatened = true;
            }
            j = j - 1;
        }

        i = row + 1;
        j = col + 1;
        while (!isThreatened & i < board.length && j < board[i].length && board[i][j] != WALL) { //Check if queen is threatened by a queen to the down-side-right of the queen spot
            if (board[i][j] == QUEEN) {
                isThreatened = true;
            }
            i = i + 1;
            j = j + 1;
        }

        i = row - 1;
        j = col + 1;
        while (!isThreatened & i >= 0 && j < board[i].length && board[i][j] != WALL) { //Check if queen is threatened by a queen to the up-side-right of the queen spot
            if (board[i][j] == QUEEN) {
                isThreatened = true;
            }
            i = i - 1;
            j = j + 1;
        }

        i = row + 1;
        j = col - 1;
        while (!isThreatened & (i < board.length & j >= 0) && board[i][j] != WALL) { //Check if queen is threatened by a queen to the down-side-left of the queen spot
            if (board[i][j] == QUEEN) {
                isThreatened = true;
            }
            i = i + 1;
            j = j - 1;
        }

        i = row - 1;
        j = col - 1;
        while (!isThreatened & (i >= 0 & j >= 0) && board[i][j] != WALL) { //Check if queen is threatened by a queen to the up-side-left of the queen spot
            if (board[i][j] == QUEEN) {
                isThreatened = true;
            }
            i = i - 1;
            j = j - 1;
        }

        return isThreatened;
    }


     /**
     * Check if board is a legal solution for k queens
     *
     * @param board a solution for the k-queens problem. Assume board not null and not empty, and each cell not null.
     * @param k number of queens that must be on the board. Assume k>=1.
     * @param rows number of rows that must be on the board. Assume rows>=1.
     * @param cols number of columns that must be on the board. Assume cols>=1.
     * @param walls locations of walls that must be on board. Assume valid value.
     * @return true if board is a legal solution for k queens, otherwise false
     */
    
    public static boolean isLegalSolution(int[][] board, int k, int rows, int cols, int[][] walls) {
        
    	boolean isLegal = true;
    	int queenCount = 0;
    	if (isValidInput(k, rows, cols, walls) == false) {
    		isLegal = false;
    	}
    	else if (validateWalls(walls, board) == false) {
    		isLegal = false;
    	}
    	else if (board.length != rows) {
    		isLegal = false;
    	}
    	else {
    		for (int i = 0; isLegal & i < board.length; i = i + 1) { //Check if all of coordinates of board for errors
    			if (board[i].length != cols) {
    				isLegal = false;
    			}
    			for (int j = 0; isLegal & j < board[i].length; j = j + 1) {
    				if (board[i][j] == QUEEN) {
    					if (isQueenThreatened(board, i, j) == true) {
    						isLegal = false;
    					}
    					queenCount = queenCount + 1;
    				}
    			}
    		}
    		if (queenCount != k) {
    			isLegal = false;
    		}
    	}
    	
    	return isLegal;
    }

     /**
     * Adds queen to cell board[row][col] if the board obtained by adding the queen is legal
     *
     * @param board represents a partial solution for k'<k queens. Assume valid value.
     * @param row queen must be added to this row. Assume valid value.
     * @param col queen must be added to this column. Assume valid value.
     * @return true if queen was added, otherwise false.
     */
    
    public static boolean addQueen(int[][] board, int row, int col) {
    	
    	boolean queenAdded = false;
    	int preValue = board[row][col];
    	
    	if (board[row][col] == EMPTY) {
    		board[row][col] = QUEEN;
    		
    		if (isQueenThreatened(board, row, col) == true) { //Remove queen from if she's threatened
    			board[row][col] = preValue;
    		}
    		else {
    			queenAdded = true;
    		}
    	}
    	
        return queenAdded;
    }

     /**
     * Solves the k queens problem.
     *
     * @param k number of queens to be located on the board
     * @param rows number of rows in the board
     * @param cols number of columns in the board
     * @param walls locations of walls on the board
     * @return board that is a legal solution, empty board if there is no solution
     */
    
    public static int[][] kQueens(int k, int rows, int cols, int[][] walls) {
        
    	int[][] board;
    	if (isValidInput(k, rows, cols, walls)) {
    		board = createBoard(rows, cols, walls);
    		if (!kQueens(board, k, 0, 0, 0)) { //Activates recursive function to find the solution if possible
    			board = new int[0][0];
    		}
    	}
    	else {
    		board = new int[0][0];
    	}
        
    	return board;
    }

     /**
     * Recursive helper function for the k queens problem
     * @param board
     * @param k
     * @param row
     * @param col
     * @param numOfQueens
     * @return
     */
    
	private static boolean kQueens(int[][] board, int k, int row, int col, int numOfQueens) {
		
		boolean isFound = false;
		
        if(k == numOfQueens) { //Stop condition
        	isFound = true;
        }
        
        if (row < board.length) {
        	int tmpValue = board[row][col];
    		int nextRow = row;
        	if (addQueen(board, row, col)) { //Add queen to the coordinates if the spot is empty and not threatened
        		if (col == board[0].length - 1) { //Condition to jumping to the next row
        			nextRow = row + 1;
        		}
        		isFound = kQueens(board, k, nextRow, (col+1) % board[0].length, numOfQueens + 1); //Calling for the recursive function from the next spot after added queen
        		if (!isFound) { //Check if there wasn't a solution to the added queen
        			board[row][col] = tmpValue; //Remove the added queen
        			isFound = kQueens(board, k, nextRow, (col+1) % board[0].length, numOfQueens); //Calling for the recursive function from the next spot after removed queen
        		}
        	}
        	else {
        		if (col == board[0].length - 1) { //Condition to jumping to the next row
        			nextRow = row + 1;
        		}
        		isFound = kQueens(board, k, nextRow, (col+1) % board[0].length, numOfQueens); //Calling for the recursive function from the next spot
        	}
        }
		
		return isFound;
		
	}
}