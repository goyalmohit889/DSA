
public class MissingPositiveAndBinarySearch {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

    
        for (int i = 0; i < n; i++) {
            while (1 <= nums[i] && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 4, -1, 1};
        System.out.println("First Missing Positive: " + firstMissingPositive(numbers)); // Output: 2

        int[] sortedNumbers = {1, 2, 3, 4, 5};
        int targetNumber = 3;
        System.out.println("Index of target number: " + binarySearch(sortedNumbers, targetNumber)); // Output: 2
    }
}
