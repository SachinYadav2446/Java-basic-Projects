import java.util.Scanner;
import java.util.Arrays;
public class SortingSearching {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║   Sorting & Searching Algorithms    ║");
        System.out.println("╚═════════════════════════════════════╝\n");
        int[] numbers = inputArray();
        if (numbers == null || numbers.length == 0) {
            System.out.println("No array to process!");
            return;
        }
        boolean continueProgram = true;
        while(continueProgram) {
            displayMenu();
            System.out.print("Enter your choice (1-5): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input!\n");
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    demonstrateSorting(numbers.clone());
                    break;
                case 2:
                    demonstrateSearching(numbers);
                    break;
                case 3:
                    compareAlgorithms();
                    break;
                case 4:
                    displayCurrentArray(numbers);
                    break;
                case 5:
                    continueProgram = false;
                    System.out.println("\nThank you!");
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }
        }
        scanner.close();
    }
    static void displayMenu() {
        System.out.println("\n--- Algorithms Menu ---");
        System.out.println("1. Demonstrate sorting algorithms");
        System.out.println("2. Demonstrate searching algorithms");
        System.out.println("3. Compare algorithm efficiency");
        System.out.println("4. Display current array");
        System.out.println("5. Exit");
    }
    static int[] inputArray() {
        System.out.print("Enter number of elements: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input!");
            scanner.nextLine();
            return null;
        }
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Size must be positive!");
            return null;
        }
        int[] arr = new int[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input!");
                scanner.nextLine();
                i--;
                continue;
            }
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
    static void demonstrateSorting(int[] arr) {
        System.out.println("\n--- Original Array ---");
        printArray(arr);
        // Bubble Sort
        System.out.println("\n--- Bubble Sort ---");
        long startTime = System.nanoTime();
        bubbleSort(arr.clone());
        long bubbleTime = System.nanoTime() - startTime;
        System.out.println("Time taken: " + bubbleTime + " ns");
        // Selection Sort
        System.out.println("\n--- Selection Sort ---");
        startTime = System.nanoTime();
        selectionSort(arr.clone());
        long selectionTime = System.nanoTime() - startTime;
        System.out.println("Time taken: " + selectionTime + " ns");
        // Quick Sort (using merge sort as alternative)
        System.out.println("\n--- Merge Sort (Efficient) ---");
        startTime = System.nanoTime();
        mergeSort(arr.clone(), 0, arr.length - 1);
        long mergeTime = System.nanoTime() - startTime;
        System.out.println("Time taken: " + mergeTime + " ns");
        System.out.println("\nNote: Merge Sort is most efficient for larger arrays");
    }
    static void demonstrateSearching(int[] arr) {
        int[] sortedArr = arr.clone();
        mergeSort(sortedArr, 0, sortedArr.length - 1);
        System.out.print("\nEnter number to search: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input!");
            scanner.nextLine();
            return;
        }
        int target = scanner.nextInt();
        // Linear Search
        System.out.println("\n--- Linear Search ---");
        long startTime = System.nanoTime();
        int linearResult = linearSearch(arr, target);
        long linearTime = System.nanoTime() - startTime;
        if (linearResult != -1) {
            System.out.println("Found at index: " + linearResult);
        } else {
            System.out.println("Not found");
        }
        System.out.println("Time taken: " + linearTime + " ns");
        // Binary Search (requires sorted array)
        System.out.println("\n--- Binary Search (on sorted array) ---");
        startTime = System.nanoTime();
        int binaryResult = binarySearch(sortedArr, target, 0, sortedArr.length - 1);
        long binaryTime = System.nanoTime() - startTime;
        if (binaryResult != -1) {
            System.out.println("Found at index: " + binaryResult);
        } else {
            System.out.println("Not found");
        }
        System.out.println("Time taken: " + binaryTime + " ns");
        System.out.println("\nNote: Binary Search is faster for large sorted arrays");
    }
    static void compareAlgorithms() {
        System.out.println("\n--- Algorithm Complexity Analysis ---");
        System.out.println("\nSORTING:");
        System.out.println("  Bubble Sort: O(n²) - Simple but slow");
        System.out.println("  Selection Sort: O(n²) - Simple but slow");
        System.out.println("  Merge Sort: O(n log n) - Fast and reliable");
        System.out.println("\nSEARCHING:");
        System.out.println("  Linear Search: O(n) - Works on unsorted arrays");
        System.out.println("  Binary Search: O(log n) - Requires sorted array");
        System.out.println("\nRECOMMENDATIONS:");
        System.out.println("  Use Merge Sort for general purpose sorting");
        System.out.println("  Use Binary Search for large sorted datasets");
    }
    static void displayCurrentArray(int[] arr) {
        System.out.println("\n--- Current Array ---");
        printArray(arr);
    }
    // Sorting Algorithms
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        System.out.println("Sorting: " + Arrays.toString(arr));
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted: " + Arrays.toString(arr));
    }
    static void selectionSort(int[] arr) {
        int n = arr.length;
        System.out.println("Sorting: " + Arrays.toString(arr));
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println("Sorted: " + Arrays.toString(arr));
    }
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }
    // Searching Algorithms
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
    static int binarySearch(int[] arr, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] > target) {
                return binarySearch(arr, target, left, mid - 1);
            }
            return binarySearch(arr, target, mid + 1, right);
        }
        return -1;
    }
    static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("]");
    }
}



