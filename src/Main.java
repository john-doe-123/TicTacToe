import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final char SYMBOL_O = 'O';
        final char SYMBOL_X = 'X';

        char playerSymbol;
        Board board = new Board();
        SelectedCell selectedCell;


        printWelcomMessage();


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

        bannerPrint(board.getWinnerOrDraw(), 25);

    }


    private static SelectedCell getUserInput(Board board) {

        Scanner scanner = new Scanner(System.in);

        int row;
        int col;
        boolean isOutsideRange;

        do {

            System.out.print("Row [1..3]: ");
            row = Integer.parseInt(scanner.nextLine());
            System.out.print("Column [1..3]: ");
            col = Integer.parseInt(scanner.nextLine());

            isOutsideRange = (row < 1 || row > 3) || (col < 1 || col > 3);

            row--;  // Subtract 1 because 1..3 is more user-friendly than 0..2;
            col--;

        } while (isOutsideRange || !board.isValidMove(board, row, col));

        return new SelectedCell(row, col);
    }

    public static void bannerPrint(String message, int width) {


        int spaces = (width - message.length() - 2) / 2;


        System.out.println(repeatChar('#', width));
        System.out.printf("%1$s%2$s%1$s%n",
                repeatChar(' ', spaces),
                message.toUpperCase());
        System.out.println(repeatChar('#', width));
    }

    public static String repeatChar(char c, int numberOfTimes) {
        return new String(new char[numberOfTimes]).replace('\0', c);
    }


    public static void printWelcomMessage() {

        bannerPrint("welcome!", 40);
        System.out.println();
    }
}
