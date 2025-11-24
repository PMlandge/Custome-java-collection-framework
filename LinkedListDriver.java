package collectionImp;

public class LinkedListDriver {

    public static void main(String[] args) {

        LinkedList<Integer> ls = new LinkedList<>();

        ls.add(10);
        ls.add(20);
        ls.add(30);
        ls.add(40);

        Iterator<Integer> i = ls.iterator();

        System.out.println(i.next());
        System.out.println(i.next());
        System.out.println(i.next());
        System.out.println(i.next());

        System.out.println(i.previous());

        System.out.println("--------------------");
        
        Iterator<Integer> i2 = ls.iterator();

        while (i2.hasNext()) {

            System.out.println(i2.next());
        }

        System.out.println("--------------------");

        Iterator<Integer> i3 = ls.iterator();

        while (i3.hasPrevious()) {
            
            System.out.println(i3.previous(true));
        }
    }
}