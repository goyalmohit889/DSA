public class CompareBufferBuilder {
    public static void main(String[] args) {
        long stTime=System.nanoTime();
        StringBuffer sb=new StringBuffer();
        StringBuilder sd=new StringBuilder();
        for(int i=0;i<1000;i++){
            sb.append("hello");
        }
        long endTime=System.nanoTime();
        long bufferTime=endTime-stTime;
        stTime=System.nanoTime();
        for(int i=0;i<1000;i++){
            sd.append("hello");
        }
        endTime=System.nanoTime();
        long builderTime=endTime-stTime;
        System.out.println("String buffer time: "+bufferTime);
        System.out.println("string builder time: "+builderTime);
    }
}
