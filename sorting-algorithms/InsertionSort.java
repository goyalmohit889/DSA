
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int empid[]={7,6,3,4,1};
        int n=empid.length;
        for(int i=1;i<n;i++){
            for(int j=i;j>=1;j--){
                if(empid[j-1]>empid[j]){
                    int swap=empid[j-1];
                    empid[j-1]=empid[j];
                    empid[j]=swap;
                }
            }
        }
        System.out.println(Arrays.toString(empid));
    }
}
