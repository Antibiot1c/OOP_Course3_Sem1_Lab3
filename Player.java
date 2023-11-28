import java.util.Scanner;

public interface Player {
    void makeMove(Board board);
}

class HumanPlayer implements Player {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void makeMove(Board board) {
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введіть ваш хід (наприклад, a2-b3): ");
            String move = scanner.nextLine().trim();

            if (isValidMoveFormat(move)) {
                int[] from = convertPosition(move.substring(0, 2));
                int[] to = convertPosition(move.substring(3, 5));

                if (board.isValidMove(from, to, true)) {
                    board.makeMove(from, to);
                    validInput = true;
                } else {
                    System.out.println("Неправильний хід. Спробуйте ще раз.");
                }
            } else {
                System.out.println("Неправильний формат ходу. Спробуйте ще раз.");
            }
        }
    }

    private boolean isValidMoveFormat(String move) {
        return move.matches("^[a-h][1-8]-[a-h][1-8]$");
    }

    private int[] convertPosition(String position) {
        int row = 8 - Character.getNumericValue(position.charAt(1));
        int col = position.charAt(0) - 'a';
        return new int[]{row, col};
    }
}

class ComputerPlayer implements Player {
    @Override
    public void makeMove(Board board) {
        int[][] move = generateComputerMove(board);
        board.makeMove(move[0], move[1]);
    }

    private int[][] generateComputerMove(Board board) {
        int fromRow, fromCol, toRow, toCol;

        do {
            fromRow = (int) (Math.random() * 8);
            fromCol = (int) (Math.random() * 8);
        } while (board.getPiece(fromRow, fromCol) != 'C');

        int[] possibleMove = getRandomMove(board, fromRow, fromCol);
        toRow = possibleMove[0];
        toCol = possibleMove[1];

        return new int[][]{{fromRow, fromCol}, {toRow, toCol}};
    }

    private int[] getRandomMove(Board board, int fromRow, int fromCol) {
      
        int[] randomMove = new int[2];

        return randomMove;
    }
}
