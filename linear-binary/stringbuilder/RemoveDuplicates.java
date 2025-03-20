import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String str="ironic";
        StringBuilder sb=new StringBuilder();
        HashSet<Character> set=new HashSet<>();
        for(char ch:str.toCharArray()){
            if(!set.contains(ch)){
                sb.append(ch);
            }
            set.add(ch);
        }

        System.out.println(sb.toString());
    }
}
