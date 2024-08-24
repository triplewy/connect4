import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class AI {
    // Determine whether AI is player 1 or player 2
    private Boolean isPlayerOne;
    // TODO: Add any other class members you may need to help with your AI class
    // You most likely won't need any new members unless you plan on storing your
    // model as a class member

    public AI(Boolean isPlayerOne) {
        this.isPlayerOne = isPlayerOne;
        // TODO: Add any other initialization steps you may deem fit
    }

    // TODO: Implement chooseCol method
    /**
     * chooseCol chooses the most optimum column to place the next token
     * 
     * @param board is the Connect4 2d token array. You should pass in a copy of the
     *              2d token array so that the AI is not modifying the actual game
     *              board
     * @return the index of the column to place the next token
     */
    public int chooseCol(Board.GameToken[][] board) {
        return -1;
    }
}
