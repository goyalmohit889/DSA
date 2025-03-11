import java.util.*;

public class CircularTour {
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStartingPoint(petrol, distance);
        if (start == -1) {
            System.out.println("No possible tour.");
        } else {
            System.out.println("Start the tour from petrol pump: " + start);
        }
    }

    private static int findStartingPoint(int[] petrol, int[] distance) {
        Queue<Integer> queue = new LinkedList<>();
        int totalSurplus = 0, surplus = 0, start = 0;

        for (int i = 0; i < petrol.length; i++) {
            int netPetrol = petrol[i] - distance[i];
            totalSurplus += netPetrol;
            surplus += netPetrol;
            queue.add(i);

            if (surplus < 0) {
                while (!queue.isEmpty()) queue.poll(); 
                start = i + 1;  
                surplus = 0;  
            }
        }

        return (totalSurplus >= 0) ? start : -1;
    }
}
