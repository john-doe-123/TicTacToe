public class Board {

    private static final int BOARD_ROWS = 3;
    private static final int BOARD_COLUMNS = 3;
    static final int TOTAL_CELLS = BOARD_ROWS * BOARD_COLUMNS;

    private String winnerOrDraw = "Draw";

    private char[][] cells = new char[BOARD_ROWS][BOARD_COLUMNS];


    public Board() {

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = '-';
            }
        }

    }

    public void printBoard() {

        System.out.println();

        System.out.println("-------------");

        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                System.out.printf("| %c ", this.cells[i][j]);
            }
            System.out.print("|");
            System.out.println();
            System.out.println("-------------");

        }

        System.out.println();
    }

    public void setPlayerSymbol(int row, int col, char playerSymbol) {

        this.cells[row][col] = playerSymbol;
    }

    public boolean isValidMove(Board board, int row, int col) {
        return board.cells[row][col] == '-';
    }

    public boolean isGameOver(Board board) {

        boolean winHorizontals = false;
        boolean winVerticals = false;
        boolean winDiagonals = false;

        for (char c : "XO".toCharArray()) {

            if ((board.cells[0][0] == c && board.cells[0][1] == c && board.cells[0][2] == c) ||        // First row
                    (board.cells[1][0] == c && board.cells[1][1] == c && board.cells[1][2] == c) ||    // Second row
                    (board.cells[2][0] == c && board.cells[2][1] == c && board.cells[2][2] == c)) {    // Third row
                winHorizontals = true;

                board.winnerOrDraw = String.format("%c WINS! ", c);


            } else if (board.cells[0][0] == c && board.cells[1][0] == c && board.cells[2][0] == c ||   // First column
                    board.cells[0][1] == c && board.cells[1][1] == c && board.cells[2][1] == c ||      // Second column
                    board.cells[0][2] == c && board.cells[1][2] == c && board.cells[2][2] == c) {      // Third column
                winVerticals = true;

                board.winnerOrDraw = String.format("%c WINS! ", c);


            } else if (board.cells[0][0] == c && board.cells[1][1] == c && board.cells[2][2] == c ||
                    board.cells[0][2] == c && board.cells[1][1] == c && board.cells[2][0] == c) {
                winDiagonals = true;

                board.winnerOrDraw = String.format("%c WINS! ", c);

            }


        }

        return winHorizontals || winVerticals || winDiagonals;

    }

    public String getWinnerOrDraw() {
        return this.winnerOrDraw;
    }
}
