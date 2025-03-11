
import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int arr[] = {100, 80, 60, 70, 60, 75, 85};
        Stack<Integer> st=new Stack<>();
        int ans[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            ans[i]=(st.isEmpty())?(i+1):(i-st.peek());
            st.push(i);
        }

        for(int i:ans){
            System.out.print(i+" ");
        }

    }
}
