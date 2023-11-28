public class Board {
    private char[][] board;
    private boolean gameOver;
    private String winner;

    public Board() {
        this.board = initializeBoard();
        this.gameOver = false;
        this.winner = null;
    }

        public void displayBoard() {
            System.out.println("  a b c d e f g h");

            for (int i = 0; i < 8; i++) {
                System.out.print(8 - i + " ");
                for (int j = 0; j < 8; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println(8 - i);
            }

            System.out.println("  a b c d e f g h");
            System.out.println();
        }


    public boolean isGameOver() {
        return gameOver;
    }

    public String getWinner() {
        return winner;
    }

    public char getPiece(int row, int col) {
        return board[row][col];
    }

    public boolean isValidMove(int[] from, int[] to, boolean isHuman) {
        int fromRow = from[0];
        int fromCol = from[1];
        int toRow = to[0];
        int toCol = to[1];

        if (fromRow < 0 || fromRow >= 8 || fromCol < 0 || fromCol >= 8 ||
                toRow < 0 || toRow >= 8 || toCol < 0 || toCol >= 8) {
            return false;
        }

        char playerPiece = isHuman ? 'H' : 'C';
        if (board[fromRow][fromCol] != playerPiece) {
            return false;
        }

        if (board[toRow][toCol] != ' ') {
            return false;
        }


        return true;
    }

        public void makeMove(int[] from, int[] to) {
            int fromRow = from[0];
            int fromCol = from[1];
            int toRow = to[0];
            int toCol = to[1];

            char piece = board[fromRow][fromCol];
            board[fromRow][fromCol] = ' ';

            board[toRow][toCol] = piece; 
          
            displayBoard();
        }

    private char[][] initializeBoard() {
        char[][] initialBoard = new char[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                initialBoard[i][j] = ' ';
            }
        }

        for (int i = 0; i < 8; i += 2) {
            initialBoard[0][i + 1] = 'H';  // Фігури людини
            initialBoard[1][i] = 'H';
            initialBoard[2][i + 1] = 'H';

            initialBoard[5][i] = 'C';  // Фігури комп'ютера
            initialBoard[6][i + 1] = 'C';
            initialBoard[7][i] = 'C';
        }

        return initialBoard;
    }
}
