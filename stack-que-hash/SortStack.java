import java.util.*;

public class SortStack {

    public static void sortStack(Stack<Integer> st) {
        if (!st.isEmpty()) {
            int top = st.pop(); 
            sortStack(st);
            insertInSortedOrder(st, top); 
        }
    }

    private static void insertInSortedOrder(Stack<Integer> st, int element) {

        if (st.isEmpty() || element > st.peek()) {
            st.push(element);
            return;
        }
        int top = st.pop();
        insertInSortedOrder(st, element);

        st.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(30);
        st.push(-5);
        st.push(18);
        st.push(14);
        st.push(-3);

        System.out.println("Original st: " + st);
        
        sortStack(st);

        System.out.println("Sorted st: " + st);
    }
}
