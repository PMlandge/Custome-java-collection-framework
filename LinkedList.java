package collectionImp;
public class LinkedList<E> {

    Node<E> head;
    Node<E> end;
    int ct = 0;

    public LinkedList() {
    }

    public boolean add(E ele) {
        if (head==null && end==null) {

            Node<E> n = new Node<E>(ele, null, null);

            head = n;
            end = n;
            ct++;
        }
        else {
            Node<E> n = new Node<E>(ele, end, null);
            end.nextRef = n;
            end = n;
            ct++;

        }

        return true;
    }

    public boolean contains(E ele)
    {
        Iterator<E> i = iterator();

        while (i.hasNext()) {

            if (i.next().equals(ele)) {

                return true;
            }
        }
        return false;
    }

    public Iterator<E> iterator()
    {
        return new Itr2<>(head, end);
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder("[");

        Iterator<E> it = iterator();

        while (it.hasNext()){
            sb = sb.append(it.next()+", ");
        }

        sb = sb.append("]");
        return sb.toString() ;
    }

    public int size()
    {
        return ct ;
    }

    public boolean equals(Object ref)
    {
        if (ref!=null) {

            if (this.getClass()==ref.getClass()) {

                LinkedList<E> passRef = (LinkedList<E>) ref;

                if (this.size()==passRef.size()) {

                    Iterator<E> i = iterator();
                    Iterator<E> i2 = passRef.iterator();

                    while (i.hasNext()) {

                        if (!(i.next().equals(i2.next()))) {

                            return false ;
                        }
                    }

                    return true ;
                }
            }
        }

        return false ;
    }
}