public class Board {
    // These are the settings of the Connect4 game. Technically the original
    // game is 6x7 but we only do 4x4 here because I haven't thought of an AI
    // algorithm that's fast enough to calculate the next move for a 6x7 board.
    // And by not fast enough I mean it will take at least an hour to generate
    // the model to think of what to do if the board is 6x7. But feel free to
    // change these parameters as you wish.
    public static final int ROWS = 4;
    public static final int COLS = 4;
    public static final int WIN_CONDITION = 3;

    // Possible game states for a Connect4 game
    public static final String LIVE = "LIVE";
    public static final String TIED = "TIED";
    public static final String PLAYER_1_WON = "PLAYER_1_WON";
    public static final String PLAYER_2_WON = "PLAYER_2_WON";

    // Possible game tokens for a Connect4 game, that being an empty space,
    // player 1 token, or player 2 token.
    public static final String EMPTY = " ";
    public static final String PLAYER_1 = "X";
    public static final String PLAYER_2 = "O";

    // board is the connect4 board
    private String[][] board;

    // Current player's turn. We can just use boolean to represent player 1 or 2.
    private Boolean turn;

    // Constructor
    public Board() {
        // Initialize connect4 board
        this.board = new String[ROWS][COLS];

        // Initialize board with empty spaces for presentation purposes
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                this.board[i][j] = EMPTY;
            }
        }

        // Initialize the turn
        this.turn = false;
    }

    // TODO: Implement cloneBoard method
    /**
     * cloneBoard creates a clone of the internal 2d-array. This is useful
     * for when the AI class needs to fiddle with the board when it's trying
     * to think of the best move to destroy you.
     * 
     * @return 2d GameToken array
     */
    public String[][] cloneBoard() {
        return null;
    }

    // TODO: Implement turn method
    /**
     * turn is used for each turn in the Connect4 game.
     * 
     * @param col is the column index to drop the next token
     * @return the game's state after the turn (i.e. LIVE, TIED, etc.)
     * @throws Exception if input is invalid or if the game is already over
     */
    public String turn(int col) throws Exception {
        return null;
    }

    // TODO: Implement getGameState method
    /**
     * getGameState gets the game's state for the current board. The method is
     * static for easier testing purposes.
     * 
     * @param board is the 2d token array that represents the connect4 game
     * @return the game state for the input board (i.e. LIVE, TIED, etc.)
     * @throws Exception if the board is not in a valid state (i.e. there are
     *                   floating tokens)
     */
    public String getGameState(String[][] board) throws Exception {
        return null;
    }

    // TODO: Implement toString method
    /**
     * toString overrides the default Java toString method. This is useful for
     * printing the board to the terminal when you play it. Can't play the game
     * if you can't see the board.
     * 
     * @return the game state for the input board
     */
    @Override
    public String toString() {
        return null;
    }
}