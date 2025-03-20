
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int examScores[]={56,30,24,26,11};
        int n=examScores.length;
        for(int i=0;i<n-1;i++){
            int idx=i;
            for(int j=i+1;j<n;j++){
                if(examScores[j]<examScores[idx]){
                    idx=j;
                }
            }
            int swap=examScores[i];
            examScores[i]=examScores[idx];
            examScores[idx]=swap;
        }

        System.out.println(Arrays.toString(examScores));

    }
}
