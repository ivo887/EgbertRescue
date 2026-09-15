import java.util.Scanner;

public class EgbertRescue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Exercise 1: read the ASCII values and build the initial message
        int n = input.nextInt();
        int k = input.nextInt();

        String initMessage = "";
        for (int i = 0; i < n; i++) {
            int value = input.nextInt();
            initMessage += (char) value;
        }
        System.out.println(initMessage);

        // Exercise 2: reverse every block of size k (last block may be shorter)
        String reversedMessage = "";
        for (int start = 0; start < initMessage.length(); start += k) {
            int end = Math.min(start + k, initMessage.length()) - 1;
            for (int i = end; i >= start; i--) {
                reversedMessage += initMessage.charAt(i);
            }
        }
        System.out.println(reversedMessage);

        // Exercise 3: every '*' removes itself and the character before it
        String purgedMessage = "";
        for (int i = 0; i < reversedMessage.length(); i++) {
            char c = reversedMessage.charAt(i);
            if (c == '*') {
                purgedMessage = purgedMessage.substring(0, purgedMessage.length() - 1);
            } else {
                purgedMessage += c;
            }
        }
        System.out.println(purgedMessage);

        // Exercise 4: subtract the index from each character's ASCII value
        String finalMessage = "";
        for (int i = 0; i < purgedMessage.length(); i++) {
            finalMessage += (char) (purgedMessage.charAt(i) - i);
        }
        System.out.println(finalMessage);

        // Exercise 5: fill the grid row by row and print it
        int cols = k;
        int rows = finalMessage.length() / k;
        char[][] grid = new char[rows][cols];

        int index = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = finalMessage.charAt(index);
                index++;
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }

        // Exercise 6: read the grid column by column
        String rescueCode = "";
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                rescueCode += grid[r][c];
            }
        }
        System.out.println(rescueCode);
    }
}
