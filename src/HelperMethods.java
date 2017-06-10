import java.util.Scanner;

public class HelperMethods {

    static void bannerPrint(String message, int width) {


        int spaces = (width - message.length() - 2) / 2;


        System.out.println(repeatChar('#', width));
        System.out.printf("%1$s%2$s%1$s%n",
                repeatChar(' ', spaces),
                message.toUpperCase());
        System.out.println(repeatChar('#', width));
    }

    private static String repeatChar(char c, int numberOfTimes) {
        return new String(new char[numberOfTimes]).replace('\0', c);
    }

    static void printWelcomeMessage() {

        bannerPrint("welcome!", 40);
        System.out.println();
    }

//    static UserNumbers getUserInput(Board board) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        int row = 0;
//        int col = 0;
//        boolean isOutsideRange = true;
//
//        do {
//
//            try {
//                System.out.print("Row [1..3]: ");
//                row = Integer.parseInt(scanner.nextLine());
//                System.out.print("Column [1..3]: ");
//                col = Integer.parseInt(scanner.nextLine());
//
//                isOutsideRange = (row < 1 || row > 3) || (col < 1 || col > 3);
//
//                row--;  // Subtract 1 because 1..3 is more user-friendly than 0..2;
//                col--;
//            } catch (NumberFormatException e) {
//                System.out.println("Numbers only please!");
//            }
//
//        } while (isOutsideRange || !board.isValidMove(board, row, col));
//
//        return new UserNumbers(row, col);
//    }

    static UserNumbers getUserInput() {

        int row = 0;
        int col = 0;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Row [1..3]: ");
            row = Integer.parseInt(scanner.nextLine());
            System.out.print("Column [1..3]: ");
            col = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Numbers only!");
        }

        return new UserNumbers(row, col);
    }

    static boolean isOutsideRange(UserNumbers userNumbers) {

        boolean isOutsideRange;

        int minRange = 1;
        int maxRange = (Board.TOTAL_CELLS / 2) - 1; // -1 because the cells are numbered 1..9;

        isOutsideRange = (userNumbers.row < minRange || userNumbers.row > maxRange) ||
                (userNumbers.col < minRange || userNumbers.col > maxRange);

        return isOutsideRange;
    }
}
