public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int mat[][]={
            {1,2,3},
            {3,4,5},
            {6,7,8}
        };
        int target=6;
        
        boolean found=searchIn2dMat(mat,target);
        if(found){
            System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }
    }

    private static boolean searchIn2dMat(int[][] mat,int target) {
        int rows=mat.length;
        int cols=mat[0].length;
        int left=0;
        int right=(rows*cols)-1;
        while(left<=right){
            int mid=(left+right)/2;
            int midVal=mat[mid/cols][mid%cols];
            if(midVal==target){
                return true;
            }else if(midVal <target){
                left=mid+1;
            }else{
                right=mid-1;
            }


        }
        return false;
    }
}