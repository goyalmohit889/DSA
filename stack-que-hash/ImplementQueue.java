import java.util.*;

public class ImplementQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;

    ImplementQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    private void enqueue(int i) {
        st1.push(i);
    }

    private void dequeue() {
        if (st2.isEmpty()) {
            if (st1.isEmpty()) {
                System.out.println("Queue is empty");
                return;
            } else {
                while (!st1.isEmpty()) {
                    st2.push(st1.pop());
                }
            }
        }
        System.out.println("Dequeued: " + st2.pop());
    }

    public void displayQueue() {
        if (st1.isEmpty() && st2.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

   
        for (int i = st2.size() - 1; i >= 0; i--) {
            System.out.print(st2.get(i) + " ");
        }

    
        for (int i = 0; i < st1.size(); i++) {
            System.out.print(st1.get(i) + " ");
        }

        System.out.println(); 
    }

    private void peek() {
        if (st2.isEmpty()) {
            if (st1.isEmpty()) {
                System.out.println("Queue is Empty");
                return;
            } else {
                while (!st1.isEmpty()) {
                    st2.push(st1.pop());
                }
            }
        }
        System.out.println("Peek is: " + st2.peek());
    }

    private boolean isEmpty() {
        return st1.isEmpty() && st2.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueue queue = new ImplementQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue(); 
        queue.dequeue();  
        queue.enqueue(40);
        queue.peek();    
        System.out.println("Is Queue Empty? " + queue.isEmpty()); 
        queue.displayQueue(); 
        queue.peek();        
    }
}
