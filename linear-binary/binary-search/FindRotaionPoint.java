public class FindRotaionPoint {
    public static void main(String[] args) {
        int arr[]={4,5,1,2,3};
        int smidx=binarySearch(arr);
        System.out.println("Index of the smallest element (rotation point): " + smidx);
        System.out.println("Smallest element: " + arr[smidx]);
    }

    private static int binarySearch(int[] arr) {
        
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(arr[mid]>arr[right]){
                left=mid+1;
            }else{
                right=mid;
            }
            
        }
        return left;
    }
}
