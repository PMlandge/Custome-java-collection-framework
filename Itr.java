package collectionImp;

import java.util.NoSuchElementException;

public class Itr<E> implements Iterator<E> {

    int cursor = 0;
    Object[] al;
    int ct = 0;

    public Itr(Object[] ref, int ct) {
        al = ref;
        this.ct = ct;
    }

    public E next() {
        if (cursor >= ct) {
            throw new NoSuchElementException("No more element");
        }
        return (E) al[cursor++];
    }

    public boolean hasNext() {
        return cursor < ct;
    }
}
