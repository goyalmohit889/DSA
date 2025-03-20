import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        // int studentMarks[]={8,7,5,6,2};
        int studentMarks[]={4, 2, 4, 1, 3, 2};
        int n=studentMarks.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(studentMarks[j]>studentMarks[j+1]){
                    int swap=studentMarks[j];
                    studentMarks[j]=studentMarks[j+1];
                    studentMarks[j+1]=swap;
                }
            }
        }
        System.out.println(Arrays.toString(studentMarks));

    }
    
}