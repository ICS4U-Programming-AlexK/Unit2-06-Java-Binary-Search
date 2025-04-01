import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
/**
 * This program populates an array with random numbers and sorts it.
 * It then allows the user to search for a number using binary search.
 * The process repeats until the user enters 'q'.
 *
 * @author Alex Kapajika
 * @version 1.1
 * @since 2025-03-31
 */
public final class BinarySearch {
    /** Defining MAX_SIZE. */
    private static final int MAX_SIZE = 10;
    /** Defining MAX_VALUE. */
    private static final int MAX_VALUE = 101;
    /**
     * Private constructor to prevent instantiation.
     */
    private BinarySearch() {
        throw new IllegalStateException("Utility Class");
    }
    /**
     * Main Method.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // Populating the array with random numbers
        int[] numArray = new int[MAX_SIZE];
        for (int counter = 0; counter < MAX_SIZE; counter++) {
            numArray[counter] = random.nextInt(MAX_VALUE);
        }
        // Sorting the array
        Arrays.sort(numArray);
        System.out.println("Sorted array: "
         + Arrays.toString(numArray));
        // Loop to keep prompting the user until they enter 'q'
        while (true) {
            System.out.print("Enter a number to search or 'q' to quit: ");
            String userInput = scanner.nextLine().trim();
            if (userInput.equalsIgnoreCase("q")) {
                System.out.println("Done.... Exiting the program.");
                break;
            }
            try {
                int userNum = Integer.parseInt(userInput);
                int index = binarySearch(numArray, userNum);
                if (index == -1) {
                    System.out.println("The number "
                     + userNum + " is not in the array.");
                } else {
                    System.out.println("The number "
                     + userNum + " was found at index " + index + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        scanner.close();
    }
    /**
     * Performs binary search on a sorted array to find the index of a number.
     *
     * @param arr The sorted array to search.
     * @param target The number to search for.
     * @return The index of the target number, or -1 if not found.
     */
    public static int binarySearch(final int[] arr, final int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
        // Number not found
    }
}
