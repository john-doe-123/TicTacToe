public class Main {

    public static void main(String[] args) {

        final char SYMBOL_O = 'O';
        final char SYMBOL_X = 'X';

        char playerSymbol;
        Board board = new Board();
        UserNumbers userNumbers;


        HelperMethods.printWelcomeMessage();


        for (int i = 0; i < Board.TOTAL_CELLS; i++) {

            playerSymbol = i % 2 == 0 ? SYMBOL_O : SYMBOL_X;

            System.out.printf("%c's move!%n", playerSymbol);
            System.out.println("---------");
            userNumbers = HelperMethods.makeMove(board);
            board.setPlayerSymbol(userNumbers.row, userNumbers.col, playerSymbol);
            board.printBoard();

            if (board.isGameOver(board)) {
                break;
            }

        }

        HelperMethods.printBanner(board.getWinnerOrDraw(), 25);

    }


}
