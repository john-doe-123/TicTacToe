import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final char SYMBOL_O = 'O';
        final char SYMBOL_X = 'X';

        char playerSymbol;
        Board board = new Board();
        SelectedCell selectedCell;


        HelperMethods.printWelcomeMessage();


        for (int i = 0; i < Board.TOTAL_CELLS; i++) {

            playerSymbol = i % 2 == 0 ? SYMBOL_O : SYMBOL_X;

            System.out.printf("%c's move!%n", playerSymbol);
            System.out.println("---------");
            selectedCell = getUserInput(board);
            board.setPlayerSymbol(selectedCell.row, selectedCell.col, playerSymbol);
            board.printBoard();

            if (board.isGameOver(board)) {
                break;
            }

        }

        HelperMethods.bannerPrint(board.getWinnerOrDraw(), 25);

    }


    private static SelectedCell getUserInput(Board board) {

        Scanner scanner = new Scanner(System.in);

        int row = 0;
        int col = 0;
        boolean isOutsideRange = true;

        do {

            try {
                System.out.print("Row [1..3]: ");
                row = Integer.parseInt(scanner.nextLine());
                System.out.print("Column [1..3]: ");
                col = Integer.parseInt(scanner.nextLine());

                isOutsideRange = (row < 1 || row > 3) || (col < 1 || col > 3);

                row--;  // Subtract 1 because 1..3 is more user-friendly than 0..2;
                col--;
            } catch (NumberFormatException e) {
                System.out.println("Numbers only please!");
            }

        } while (isOutsideRange || !board.isValidMove(board, row, col));

        return new SelectedCell(row, col);
    }

}
