import java.util.Scanner;

public class HelperMethods {

    private static String repeatChar(char c, int numberOfTimes) {
        return new String(new char[numberOfTimes]).replace('\0', c);
    }

    static void printWelcomeMessage() {

        printBanner("welcome!", 40);
        System.out.println();
    }


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
           // System.out.println("Numbers only!");
        }

        return new UserNumbers(row - 1 , col - 1);
    }

    private static boolean isOutsideRange(UserNumbers userNumbers) {

        boolean isOutsideRange;

        int minRange = 0;
        int maxRange = Board.TOTAL_CELLS / 2;

        isOutsideRange = (userNumbers.row < minRange || userNumbers.row > maxRange) ||
                (userNumbers.col < minRange || userNumbers.col > maxRange);

        return isOutsideRange;
    }


    static UserNumbers makeMove(Board board) {

        UserNumbers userNumbers;

        do {
            userNumbers = getUserInput();

            if (isOutsideRange(userNumbers) || !board.isValidMove(board, userNumbers)) {
                System.out.println("Not a valid move or number. Please choose a free cell!");
            }

        } while (isOutsideRange(userNumbers) || !board.isValidMove(board, userNumbers));


        return userNumbers;
    }


    static void printBanner(String message, int width) {

        int leftSpaces = (width - message.length() - 2) / 2;
        int rightSpaces = leftSpaces;

        if (message.length() % 2 != 0 ^ width % 2 != 0) {
            rightSpaces++;
        }

        System.out.println(repeatChar('#', width));
        System.out.printf("#%1$s%2$s%3$s#%n",
                repeatChar(' ', leftSpaces),
                message.toUpperCase(),
                repeatChar(' ', rightSpaces));
        System.out.println(repeatChar('#', width));
        System.out.println();
    }
}
