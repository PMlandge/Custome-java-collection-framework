package collectionImp;

public class ArrayListDriver 
{
    public static void main(String[] args) 
    {	
        ArrayList<Integer> al = new ArrayList<>();  
        
        al.add(10);
        al.add(67);
        al.add(10);
        al.add(12);
        al.add(11);
        al.add(11);
        al.add(10);
        al.add(13);
        al.add(10);

        al.add(1, 1000);  // addimng at index

        System.out.println("Original List: " + al);

        al.removeDuplicates();
        System.out.println("After removeDuplicates: " + al);

        
        ArrayList<Integer> reversedList = al.reversed();
        System.out.println("Reversed List: " + reversedList);

        
        al.rotate(3);
        System.out.println("After rotate(3): " + al);

        
        System.out.println("Contains 12? " + al.contains(12));
        System.out.println("Size: " + al.size());
        System.out.println("Is Empty? " + al.isEmpty());


        System.out.println("Removed element at index 2: " + al.remove(2));
        System.out.println("After remove(2): " + al);


        al.set(1, 9999);
        System.out.println("After set(1, 9999): " + al);

        ArrayList<Integer> sub = al.subList(1, 4);
        System.out.println("SubList(1, 4): " + sub);
    }
}
