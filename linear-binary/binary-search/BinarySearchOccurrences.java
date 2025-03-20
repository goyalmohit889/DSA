public class BinarySearchOccurrences {
    public static int[] findFirstAndLast(int[] arr, int target) {
        int first = findFirst(arr, target);
        int last = findLast(arr, target);
        
        return new int[] {first, last};
    }

    private static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int first = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                first = mid;
                right = mid - 1; // Continue searching on the left side
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return first;
    }

    private static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int last = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                last = mid;
                left = mid + 1; // Continue searching on the right side
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int[] result = findFirstAndLast(sortedArray, target);
        System.out.println("First and Last Occurrence: " + result[0] + ", " + result[1]); // Output: 1, 3
    }
}
