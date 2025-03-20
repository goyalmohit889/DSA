import java.util.Arrays;

public class SearchOperations {
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int target = 4;

        int missingNumber = findFirstMissingPositive(arr);
        System.out.println("First Missing Positive: " + missingNumber);

        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));

        int targetIndex = binarySearch(arr, target);
        System.out.println("Target " + target + " found at index: " + targetIndex);
    }

    private static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

      
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]); 
            }
        }

       
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1; 
    }


    private static int binarySearch(int[] arr, int target) {
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
}
