import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        // Scanner sc=new Scanner(System.in);
        int ages[]={15,18,16,15,12,16,11};
        int max=Integer.MIN_VALUE;
        for(int i:ages){
            max=Math.max(i, max);
        }
        int cnt[]=new int[max+1];
        for(int i:ages){
            cnt[i]++;
        }
        int sum=0;
        for(int i=0;i<cnt.length;i++){
            sum+=cnt[i];
            cnt[i]=sum;
        }
        int ans[]=new int[ages.length];
        for(int i=ages.length-1;i>=0;i--){
            int age=ages[i];
            ans[cnt[age]-1]=age;
            cnt[age]--; 
        }
        System.out.println(Arrays.toString(ans));
        
    }
}
