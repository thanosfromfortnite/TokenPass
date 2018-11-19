public class TokenPass {
    private int[] board; private int currentPlayer;

    public TokenPass(int playerCount) {
        board = new int[playerCount];
        for (int i = 0; i < playerCount - 1; i ++) {
            board[i] = (int) (Math.random() * 9) + 1;
        }
        currentPlayer = (int) (Math.random() * (playerCount - 1));
    }

    public void distributeCurrentPlayerTokens() {
        int tokens = board[currentPlayer];
        for (int i = currentPlayer; tokens != 0; i ++) {
            board[i] ++; tokens --;
            if (i == board.length - 1) {
                i = 0;
            }
        }
    }

    public void nextPlayer() {
        if (currentPlayer == board.length - 1) {
            currentPlayer = 0;
        }
        else {
            currentPlayer++;
        }
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i ++) {
            System.out.println("Player " + i + ": " + board[i] + "\n");
        }
    }

    public int gameOver() {
        int out = -1;
        int max = 0;
        for (int i = 0; i < board.length; i ++) {
            if (board[i] > max) {
                out = i;
                max = board[i];
            }
        }
        return out;
    }
}
