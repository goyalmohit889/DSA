public class ReverseString {
    public static void main(String[] args) {
        String str="Hello";
        StringBuilder sb=new StringBuilder();
        sb.append(str);
        System.out.println("Original String: "+sb.toString());
        sb.reverse();
        System.out.println("Reversed String: "+sb.toString());
    }
}
