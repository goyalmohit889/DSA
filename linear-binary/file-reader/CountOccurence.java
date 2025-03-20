
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountOccurence {
    public static void main(String[] args) {
        String file="simple.txt";
        try {
            FileReader f=new FileReader(file);
            BufferedReader reader=new BufferedReader(f);
            int cnt=0;
            String word="hii";
            String line;
            while((line=reader.readLine())!=null){
                String arr[]=line.split(" ");
                for(String w:arr){
                    if(w.equalsIgnoreCase(word)){
                        cnt++;
                    }
                }
            }
            System.out.println("word count is: "+cnt);
        } catch (IOException e) {
            System.out.println("error while reading file"+e.getMessage());
        }
    }
}
