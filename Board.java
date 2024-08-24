public class Board {
    // These are the settings of the Connect4 game. Technically the original
    // game is 6x7 but we only do 4x5 here because I haven't thought of an AI
    // algorithm that's fast enough to calculate the next move for a 6x7 board.
    // And by not fast enough I mean it will take at least an hour to generate
    // the model to think of what to do if the board is 6x7. But feel free to
    // change these parameters as you wish.
    public static final int ROWS = 4;
    public static final int COLS = 5;
    public static final int WIN_CONDITION = 4;

    /**
     * GameState is the possible states of a Connect4 game
     */
    public enum GameState {
        LIVE,
        TIED,
        PLAYER_1_WON,
        PLAYER_2_WON,
    }

    /**
     * GameToken is one of the three tokens in a Connect4 game, that being an
     * empty space, player 1 token, or player 2 token. Using an enum representation
     * for the board instead of a string or int just makes the code more readable
     * and helps with printing the board
     */
    public enum GameToken {
        EMPTY(" "),
        PLAYER_1("X"),
        PLAYER_2("0");

        private final String name;

        GameToken(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    // TODO: Define class members

    // TODO: Define constructor
    public Board() {
    }

    // TODO: Implement cloneBoard method
    /**
     * cloneBoard creates a clone of the internal 2d-array. This is useful
     * for when the AI class needs to fiddle with the board when it's trying
     * to think of the best move to destroy you.
     * 
     * @return 2d GameToken array
     */
    public GameToken[][] cloneBoard() {
        return null;
    }

    // TODO: Implement turn method
    /**
     * turn is used for each turn in the Connect4 game.
     * 
     * @param col is the column index to drop the next token
     * @return the game's state after the turn
     * @throws Exception if input is invalid or if the game is already over
     */
    public GameState turn(int col) throws Exception {
        return null;
    }

    // TODO: Implement getGameState method
    /**
     * getGameState is a static method to calculate the game's state given a
     * board
     * of tokens. The method is static because the AI class would find it useful
     * for determining which moves help it win.
     * 
     * @param board is the 2d token array that represents the connect4 game
     * @return the game state for the input board
     * @throws Exception if the board is not in a valid state (i.e. there are
     *                   floating tokens)
     */
    public static GameState getGameState(GameToken[][] board) throws Exception {
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
