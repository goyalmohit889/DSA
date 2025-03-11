import java.util.*;

public class ZeroSumSubarrays {
    public static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        System.out.println("Zero-sum subarrays:");

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; 

            if (sumMap.containsKey(sum)) {
                for (int startIdx : sumMap.get(sum)) {
                    System.out.println("Subarray found from index " + (startIdx + 1) + " to " + i);
                }
            }

            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        findZeroSumSubarrays(arr);
    }
}
