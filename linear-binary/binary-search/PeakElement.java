public class PeakElement {
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 7, 8, 3};  //output 8
        int peak=binarySearch(arr);
        System.out.println(peak);
    }

    private static int binarySearch(int[] arr) {
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if ((mid == 0 || arr[mid] > arr[mid - 1]) &&
            (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
            return arr[mid];
        }
        if (mid > 0 && arr[mid - 1] > arr[mid]) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        }
        return -1;
    }
}
