import java.util.*;

class ArrayStringOperations {
    int[] arr;
    String str;

    ArrayStringOperations(int[] arr, String str) {
        this.arr = arr;
        this.str = str;
    }

    void reverseArray() {
        System.out.print("Reversed Array: ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void sortArray() {
        int[] temp = arr.clone();
        Arrays.sort(temp);
        System.out.println("Sorted Array: " + Arrays.toString(temp));
    }

    void searchElement(int key) {
        boolean found = false;

        for (int num : arr) {
            if (num == key) {
                found = true;
                break;
            }
        }

        if (found)
            System.out.println(key + " found in the array");
        else
            System.out.println(key + " not found in the array");
    }

    void findAverage() {
        int sum = 0;

        for (int num : arr) {
            sum += num;
        }

        double average = (double) sum / arr.length;
        System.out.println("Average = " + average);
    }

    void findMaximum() {
        int max = arr[0];

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        System.out.println("Maximum Element = " + max);
    }

    void reverseString() {
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        System.out.println("Reversed String = " + reversed);
    }
}

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.nextLine();

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        ArrayStringOperations obj = new ArrayStringOperations(arr, str);

        obj.reverseArray();
        obj.sortArray();

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        obj.searchElement(key);

        obj.findAverage();
        obj.findMaximum();
        obj.reverseString();
    }
}