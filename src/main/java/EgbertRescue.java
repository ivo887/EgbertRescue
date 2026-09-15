import java.util.Scanner;

public class EgbertRescue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();

        String initMessage = readMessage(input, n);
        System.out.println(initMessage);

        String reversedMessage = reverseBlocks(initMessage, k);
        System.out.println(reversedMessage);

        String purgedMessage = purge(reversedMessage);
        System.out.println(purgedMessage);

        String finalMessage = shiftByIndex(purgedMessage);
        System.out.println(finalMessage);

        char[][] grid = buildGrid(finalMessage, k);
        printGrid(grid);

        String rescueCode = readByColumns(grid);
        System.out.println(rescueCode);
    }

    public static String readMessage(Scanner input, int n) {
        String message = "";
        for (int i = 0; i < n; i++) {
            int value = input.nextInt();
            message += (char) value;
        }
        return message;
    }

    public static String reverseBlocks(String message, int k) {
        String reversed = "";
        for (int start = 0; start < message.length(); start += k) {
            int end = Math.min(start + k, message.length()) - 1;
            for (int i = end; i >= start; i--) {
                reversed += message.charAt(i);
            }
        }
        return reversed;
    }

    public static String purge(String message) {
        String purged = "";
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c == '*') {
                purged = purged.substring(0, purged.length() - 1);
            } else {
                purged += c;
            }
        }
        return purged;
    }

    public static String shiftByIndex(String message) {
        String shifted = "";
        for (int i = 0; i < message.length(); i++) {
            shifted += (char) (message.charAt(i) - i);
        }
        return shifted;
    }

    public static char[][] buildGrid(String message, int cols) {
        int rows = message.length() / cols;
        char[][] grid = new char[rows][cols];

        int index = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = message.charAt(index);
                index++;
            }
        }
        return grid;
    }

    public static void printGrid(char[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static String readByColumns(char[][] grid) {
        String result = "";
        if (grid.length == 0) {
            return result;
        }
        for (int c = 0; c < grid[0].length; c++) {
            for (int r = 0; r < grid.length; r++) {
                result += grid[r][c];
            }
        }
        return result;
    }
}
