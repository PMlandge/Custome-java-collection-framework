package collectionImp;

public class ArrayDequeDriver {

    public static void main(String[] args) {

        Deque<Integer> ad = new ArrayDeque<>();

        ad.addFirst(23);
        ad.addFirst(22);
        ad.addLast(0);
        ad.addLast(10);

        System.out.println("Deque: " + ad);

        System.out.println("removeFirst(): " + ad.removeFirst());
        System.out.println("removeLast(): " + ad.removeLast());

        System.out.println("Deque after removals: " + ad);

        // Use poll instead of remove to avoid exception
        System.out.println("poll(): " + ad.poll());
        System.out.println("pollLast(): " + ad.pollLast());

        // Now queue is empty, further polls return null
        System.out.println("pollFirst(): " + ad.pollFirst());

        System.out.println("Final Deque: " + ad);
    }
}
