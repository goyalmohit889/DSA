
import java.io.BufferedReader;
import java.io.FileReader;



public class ReadFile {
    public static void main(String[] args) {
        String fileName="output.txt";
        try {
            FileReader file=new FileReader(fileName);
            BufferedReader reader=new BufferedReader(file);

            String line;
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("error while reading file"+e.getMessage());
        }


    }
}
