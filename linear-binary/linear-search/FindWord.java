
import java.util.ArrayList;

public class FindWord {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("this is my house");
        list.add("you are a good boy");
        list.add("how are you");
        String word="are";
        String ans=helper(list,word);
        if(ans.length()>0){
            System.out.print("Found: "+ans);
        }else{
            System.out.print("Not Found");
        }
    }
    public static String helper(ArrayList<String> list,String word){
        for(String s:list){
            String arr[]=s.split(" ");
            for(String w:arr){
                if(w.equalsIgnoreCase(word)){
                    return s;
                }
            }
        }
        return "";
    
    }
}
