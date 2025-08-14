package tictactoe.utilities;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Singleton utility class for console input/output operations
 * Provides methods to read text, numbers from console and print formatted
 * output
 */
public class ConsoleUtils {

    // Singleton instance
    private static ConsoleUtils instance;
    private Scanner scanner;

    // ANSI color codes for formatting
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    private static final String UNDERLINE = "\u001B[4m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";

    /**
     * Private constructor to prevent instantiation
     */
    private ConsoleUtils() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Gets the singleton instance of ConsoleUtils
     * 
     * @return the singleton instance
     */
    public static ConsoleUtils getInstance() {
        if (instance == null) {
            synchronized (ConsoleUtils.class) {
                if (instance == null) {
                    instance = new ConsoleUtils();
                }
            }
        }
        return instance;
    }

    // ==================== INPUT METHODS ====================

    /**
     * Reads a string from the console
     * 
     * @param prompt the message to display to the user
     * @return the string entered by the user
     */
    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    /**
     * Reads a string from the console without a prompt
     * 
     * @return the string entered by the user
     */
    public String readString() {
        return scanner.nextLine().trim();
    }

    /**
     * Reads an integer from the console with input validation
     * 
     * @param prompt the message to display to the user
     * @return the integer entered by the user
     */
    public int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine(); // consume the newline
                return value;
            } catch (InputMismatchException e) {
                printError("Invalid input! Please enter a valid integer.");
                scanner.nextLine(); // clear the invalid input
            }
        }
    }

    /**
     * Reads an integer within a specified range
     * 
     * @param prompt the message to display to the user
     * @param min    minimum allowed value (inclusive)
     * @param max    maximum allowed value (inclusive)
     * @return the integer entered by the user within the specified range
     */
    public int readIntInRange(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            } else {
                printError("Please enter a number between " + min + " and " + max + ".");
            }
        }
    }

    /**
     * Reads a double from the console with input validation
     * 
     * @param prompt the message to display to the user
     * @return the double entered by the user
     */
    public double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = scanner.nextDouble();
                scanner.nextLine(); // consume the newline
                return value;
            } catch (InputMismatchException e) {
                printError("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // clear the invalid input
            }
        }
    }

    /**
     * Reads a float from the console with input validation
     * 
     * @param prompt the message to display to the user
     * @return the float entered by the user
     */
    public float readFloat(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                float value = scanner.nextFloat();
                scanner.nextLine(); // consume the newline
                return value;
            } catch (InputMismatchException e) {
                printError("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // clear the invalid input
            }
        }
    }

    /**
     * Reads a long from the console with input validation
     * 
     * @param prompt the message to display to the user
     * @return the long entered by the user
     */
    public long readLong(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                long value = scanner.nextLong();
                scanner.nextLine(); // consume the newline
                return value;
            } catch (InputMismatchException e) {
                printError("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // clear the invalid input
            }
        }
    }

    /**
     * Reads a boolean from the console (y/n, yes/no, true/false)
     * 
     * @param prompt the message to display to the user
     * @return the boolean value
     */
    public boolean readBoolean(String prompt) {
        while (true) {
            String input = readString(prompt + " (y/n): ").toLowerCase();
            if (input.equals("y") || input.equals("yes") || input.equals("true")) {
                return true;
            } else if (input.equals("n") || input.equals("no") || input.equals("false")) {
                return false;
            } else {
                printError("Please enter 'y' or 'n'.");
            }
        }
    }

    // ==================== OUTPUT METHODS ====================

    /**
     * Prints a title with formatting (bold and underlined)
     * 
     * @param title the title text to print
     */
    public void printTitle(String title) {
        System.out.println(BOLD + UNDERLINE + title + RESET);
    }

    /**
     * Prints a title with a specific color
     * 
     * @param title the title text to print
     * @param color the color code (use provided color constants)
     */
    public void printTitle(String title, String color) {
        System.out.println(color + BOLD + UNDERLINE + title + RESET);
    }

    /**
     * Prints normal text
     * 
     * @param text the text to print
     */
    public void printText(String text) {
        System.out.println(text);
    }

    /**
     * Prints text with a specific color
     * 
     * @param text  the text to print
     * @param color the color code
     */
    public void printText(String text, String color) {
        System.out.println(color + text + RESET);
    }

    /**
     * Prints text without a newline
     * 
     * @param text the text to print
     */
    public void print(String text) {
        System.out.print(text);
    }

    /**
     * Prints an error message in red
     * 
     * @param message the error message
     */
    public void printError(String message) {
        System.out.println(RED + "ERROR: " + message + RESET);
    }

    /**
     * Prints a success message in green
     * 
     * @param message the success message
     */
    public void printSuccess(String message) {
        System.out.println(GREEN + "SUCCESS: " + message + RESET);
    }

    /**
     * Prints a warning message in yellow
     * 
     * @param message the warning message
     */
    public void printWarning(String message) {
        System.out.println(YELLOW + "WARNING: " + message + RESET);
    }

    /**
     * Prints an info message in blue
     * 
     * @param message the info message
     */
    public void printInfo(String message) {
        System.out.println(BLUE + "INFO: " + message + RESET);
    }

    /**
     * Prints a separator line
     */
    public void printSeparator() {
        System.out.println("=" + "=".repeat(50));
    }

    /**
     * Prints a separator line with custom character and length
     * 
     * @param character the character to use for the separator
     * @param length    the length of the separator
     */
    public void printSeparator(char character, int length) {
        System.out.println(String.valueOf(character).repeat(length));
    }

    /**
     * Prints empty lines for spacing
     * 
     * @param lines number of empty lines to print
     */
    public void printNewLines(int lines) {
        for (int i = 0; i < lines; i++) {
            System.out.println();
        }
    }

    /**
     * Clears the console (works on most terminals)
     */
    public void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[2J\033[H");
                System.out.flush();
            }
        } catch (Exception e) {
            // If clearing fails, just print some newlines
            printNewLines(50);
        }
    }

    /**
     * Waits for user to press Enter
     */
    public void waitForEnter() {
        printText("Press Enter to continue...");
        scanner.nextLine();
    }

    /**
     * Closes the scanner (call this when the application is shutting down)
     */
    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }

    // ==================== COLOR CONSTANTS ====================

    public static String getColorReset() {
        return RESET;
    }

    public static String getColorBold() {
        return BOLD;
    }

    public static String getColorUnderline() {
        return UNDERLINE;
    }

    public static String getColorRed() {
        return RED;
    }

    public static String getColorGreen() {
        return GREEN;
    }

    public static String getColorYellow() {
        return YELLOW;
    }

    public static String getColorBlue() {
        return BLUE;
    }

    public static String getColorPurple() {
        return PURPLE;
    }

    public static String getColorCyan() {
        return CYAN;
    }
}
