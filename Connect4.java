import java.util.Scanner;

public class Connect4 {
    /**
     * GameMode represents the types of modes we can play for this Connect4 game
     */
    private enum GameMode {
        PVP,
        AI_PLAYER_1,
        AI_PLAYER_2
    }

    /**
     * getUserOption is a helper function that forces the user to enter a valid
     * option
     * 
     * @param scanner     is the CLI (Command-Line Interface) scanner
     * @param optionText  is a list of option descriptions
     * @param optionInput is a list of option inputs the user must input
     * @return the index of the option selected
     */
    private static int getUserOption(Scanner scanner, String[] optionText, String[] optionInput) {
        String input;
        while (true) {
            // Print out the option text
            for (String text : optionText) {
                System.err.println(text);
            }
            System.out.print(">> ");
            // Get the user's input
            input = scanner.nextLine();
            // Check if the input matches any of the desired inputs
            for (int i = 0; i < optionInput.length; i++) {
                if (input.equals(optionInput[i])) {
                    return i;
                }
            }
            // If it doesn't match any of the inputs go through the loop again
            System.out.println("Invalid input");
        }
    }

    /**
     * gameLoop runs the game loop from start to finish, prompting the user or AI
     * for the next turn until the game is over.
     * 
     * @param scanner  is the CLI (Command-Line Interface) scanner
     * @param gameMode is the game mode for this Connect4 game
     */
    private static void gameLoop(Scanner scanner, GameMode gameMode) throws Exception {
        // Create the board
        Board board = new Board();
        // Create AI reference but don't instantiate it. Saves some memory and
        // processing time in case your AI generates the model on instantiation
        AI ai = null;
        if (gameMode != GameMode.PVP) {
            ai = new AI(gameMode == GameMode.AI_PLAYER_1);
        }
        // Create a boolean to track the turn, where false represents player 1's
        // turn and vice versa
        Boolean turn = false;
        while (true) {
            System.out.println("-----------------------");
            // Print the board
            System.out.println(board.toString());
            // Get the column to place the next Connect4 token
            int col;
            // Check if it's AI's turn to choose the column
            if (gameMode != GameMode.PVP && ((!turn && gameMode == GameMode.AI_PLAYER_1) ||
                    (turn && gameMode == GameMode.AI_PLAYER_2))) {
                if (ai == null) {
                    throw new Exception("AI shouldn't be null");
                }
                col = ai.chooseCol(board.cloneBoard());
                System.out.println(String.format(">> AI chose column: %d", col + 1));
            }
            // If it's not AI's turn, prompt the user for the next column
            else {
                String[] optionTexts = {
                        "Enter column to place token:",
                };
                String[] optionInputs = {
                        "1",
                        "2",
                        "3",
                        "4",
                        "5",
                        "6",
                        "7"
                };
                col = getUserOption(scanner, optionTexts, optionInputs);
            }
            // Perform the turn
            Board.GameState state = board.turn(col);
            // Check the state of the game following the turn to see if we
            // continue the game or not
            if (state != Board.GameState.LIVE) {
                System.out.println(board.toString());
                switch (state) {
                    case TIED:
                        System.err.println("Tied");
                        return;
                    case PLAYER_1_WON:
                        System.err.println("Player 1 won");
                        return;
                    case PLAYER_2_WON:
                        System.err.println("Player 2 won");
                        return;
                    default:
                        break;
                }
                return;
            }
            // If we are still going, then flip the turn
            turn = !turn;
        }
    }

    public static void main(String[] args) {
        // Create the CLI (Command-Line Interface) scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Connect4!");

        int input;

        try {
            while (true) {
                System.out.println("----------------------------------------------");
                // Prompt user whether they want to play pvp or against AI
                String[] optionTexts = {
                        "Play PvP [1]",
                        "Play AI  [2]",
                };
                String[] optionInputs = {
                        "1",
                        "2",
                };
                input = getUserOption(scanner, optionTexts, optionInputs);
                switch (input) {
                    case 0:
                        gameLoop(scanner, GameMode.PVP);
                        break;
                    case 1:
                        // Prompt user whether they want to play as player 1 or player 2
                        // against the AI
                        String[] playerOptionTexts = {
                                "Play as Player 1 [1]",
                                "Play as Player 2 [2]"
                        };
                        String[] playerOptionInputs = {
                                "1",
                                "2",
                        };
                        input = getUserOption(scanner, playerOptionTexts, playerOptionInputs);
                        switch (input) {
                            case 0:
                                gameLoop(scanner, GameMode.AI_PLAYER_2);
                                break;
                            case 1:
                                gameLoop(scanner, GameMode.AI_PLAYER_1);
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        // If we hit an exception, then just quit the game
        catch (Exception e) {
            System.err.println(e);
            scanner.close();
        }

    }
}