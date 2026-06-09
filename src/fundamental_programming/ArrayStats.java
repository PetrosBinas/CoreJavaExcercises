package fundamental_programming;

public class ArrayStats {

    public static void main(String[] args) {

        int[] arr = {12, 5, 8, 20, 33, 7, 18, 2};

        printArrNums(arr);
        printLargestNum(arr);
        printSmallestNum(arr);
        printSum(arr);
        printAvg(arr);
        printEvenNums(arr);
        printOddNums(arr);

    }

    static void printArrNums(int[] arr) {

        System.out.print("Numbers: ");
        for (int num : arr) {
            System.out.printf("%d ", num);
        }
        System.out.println();
    }

    static void printLargestNum(int[] arr) {

        int largestNum = arr[0];
        for (int num : arr) {
            if (num > largestNum) largestNum = num;
        }

        System.out.printf("Largest: %d\n", largestNum);
    }

    static void printSmallestNum(int[] arr) {

        int smallestNum = arr[0];
        for (int num : arr) {
            if (num < smallestNum) smallestNum = num;
        }

        System.out.printf("Smallest: %d\n", smallestNum);
    }

    static void printSum(int[] arr) {

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        System.out.printf("Sum: %d\n", sum);
    }

    static void printAvg(int[] arr) {

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        System.out.printf("Average: %.2f\n", (float) sum/(arr.length));
    }

    static void printEvenNums(int[] arr) {

        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                count++;
            }
        }

        System.out.printf("Even Numbers: %d\n", count);
    }

    static void printOddNums(int[] arr) {

        int count = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                count++;
            }
        }
        System.out.printf("Odd NUmbers: %d\n", count);
    }

}


