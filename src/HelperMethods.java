public class HelperMethods {

    static void bannerPrint(String message, int width) {


        int spaces = (width - message.length() - 2) / 2;


        System.out.println(repeatChar('#', width));
        System.out.printf("%1$s%2$s%1$s%n",
                repeatChar(' ', spaces),
                message.toUpperCase());
        System.out.println(repeatChar('#', width));
    }

    static String repeatChar(char c, int numberOfTimes) {
        return new String(new char[numberOfTimes]).replace('\0', c);
    }

    static void printWelcomeMessage() {

        bannerPrint("welcome!", 40);
        System.out.println();
    }
}
