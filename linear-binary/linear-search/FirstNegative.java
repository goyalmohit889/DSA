public class FirstNegative {
    public static void main(String[] args) {
        int arr[]={1,2,3,-3,5,6,7};
        int n=helper(arr);

        if(n==-1){
            System.out.println("Not found");
        }else{
            System.out.println("Found at "+n);
        }
    }

    private static int helper(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<0){
                return i;
            }
        }
        return -1;
    }
}
