package main.Deque;


public class Test {
    public static void main(String[] args) {
        Deque dq = new Deque();

        dq.addFirst(3);
        dq.addLast(4);

        System.out.println(dq.removeFirst());
        System.out.println(dq.removeLast());
        System.out.println(dq.removeLast());
    }
}
