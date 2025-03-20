public class ConcatenateString {
    public static void main(String[] args) {
        String arr[]={"hii","how","are","you"};
        StringBuffer sb=new StringBuffer();
        for(String a:arr){
            sb.append(a+" ");
        }
        System.out.println(sb.toString());
    }
}
