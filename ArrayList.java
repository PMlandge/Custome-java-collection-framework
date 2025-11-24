package collectionImp;

import java.util.Arrays;

public class ArrayList<E> implements Iterable<E> {

    private int ct = 0;
    private int cp = 10;
    private Object ar[];

    public ArrayList() {
        ar = new Object[cp];
    }

    public ArrayList(int initalcp) {
        ar = new Object[initalcp];
    }

    public boolean add(E ele) {
        if (ct < 0.75 * ar.length) {
            ar[ct] = ele;
            ct++;
            return true;
        } else {
            Object[] temp = new Object[ar.length * 2];

            for (int i = 0; i < ct; i++) {
                temp[i] = ar[i];
            }
            temp[ct] = ele;
            ct++;
            ar = temp;
            return true;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < ct; i++) {
            if (i < ct - 1) {
                sb.append(ar[i] + " ,");
            } else {
                sb.append(ar[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean add(int index, E ele) {

        if (index >= 0 && index < ct) {

            if (ct < 0.75 * ar.length) {

                for (int i = ct; i > index; i--) {
                    ar[i] = ar[i - 1];
                }
                ar[index] = ele;

                ct++;
                return true;
            } else {
                Object temp[] = new Object[ar.length * 2];

                for (int i = 0; i <= ct; i++) {

                    if (i < index) {
                        temp[i] = ar[i];
                    } else if (i == index) {
                        temp[i] = ele;
                    } else {
                        temp[i] = ar[i - 1];
                    }
                }
                ct++;
                ar = temp;
                return true;
            }
        }
        return false;
    }

    public void addFirst(E ele) {
        add(0, ele);
    }

    public void addLast(E ele) {
        add(ele);
    }

    public int size() {
        return ct;
    }

    public void clear() {
        Arrays.fill(ar, null);
        ct = 0;
    }

    public E get(int index) {

        if (index >= 0 && index < ct) {
            return (E) ar[index];
        }

        throw new IndexOutOfBoundsException("index not in range");
    }

    public boolean contains(E ele) {
        return indexOf(ele) != -1;
    }

    public int indexOf(E ele) {

        int i;
        for (i = 0; i < ct; i++) {
            if (ar[i].equals(ele)) {
                break;
            }
        }
        if (i != ct) {
            return i;
        }
        return -1;
    }

    public boolean isEmpty() {
        return ct == 0;
    }

    public Object[] toArray() {

        Object ans[] = new Object[ct];

        for (int i = 0; i < ct; i++) {
            ans[i] = ar[i];
        }

        return ans;
    }

    public boolean remove(E ele) {

        int index = indexOf(ele);

        if (index != -1) {

            remove(index);
            ct--;
            return true;
        }
        return false;
    }

    public E remove(int index) {

        if (index >= 0 && index < ct) {

            E temp = (E) ar[index];
            for (int i = index; i < ct - 1; i++) {
                ar[i] = ar[i + 1];
            }

            ct--;

            return temp;
        }
        throw new IndexOutOfBoundsException("index not in range");
    }

    public E set(int index, E ele) {

        if (index >= 0 && index <= ct) {
            E prev = (E) ar[index];
            ar[index] = ele;
            return prev;
        }
        throw new IndexOutOfBoundsException("index not in range!");
    }

    public boolean removeAll(ArrayList<E> ref) {

        for (int i = 0; i < ref.size(); i++) {

            for (int j = 0; j < ct; ) {

                if (ref.get(i).equals(ar[j])) {
                    remove(j);
                } else {
                    j++;
                }
            }
        }

        return true;
    }

    public Iterator<E> iterator() {
        Itr<E> ref = new Itr<>(ar, ct);
        return ref;
    }

    public boolean retainAll(ArrayList<E> ref) {

        Object temp[] = new Object[ref.size()];
        int index = 0;

        for (int i = 0; i < ref.size(); i++) {

            for (int j = 0; j < ar.length; j++) {

                if (ref.get(i).equals(ar[j])) {

                    temp[index] = ar[j];
                    index++;
                }
            }
        }
        ar = temp;
        ct = index;
        return true;
    }

    public boolean addAll(ArrayList<E> ref) {

        for (int i = 0; i < ref.size(); i++) {

            add(ref.get(i));
        }
        return true;
    }

    public boolean addAll(int index, ArrayList<E> ref) {

        if (index >= 0 && index < ct) {

            Object[] temp = new Object[ref.size() + ct];

            for (int i = 0; i < temp.length; i++) {

                if (i < index) {
                    temp[i] = ar[i];
                } else if (i < index + ref.size()) {

                    temp[i] = ref.get(i - index);
                } else {
                    temp[i] = ar[i - ref.size()];
                }
            }
            ar = temp;
            ct = temp.length;
            return true;
        }
        return false;
    }

    public boolean containsAll(ArrayList<E> ref) {

        for (int i = 0; i < ref.size(); i++) {

            if (!contains(ref.get(i))) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<E> reversed() {

        ArrayList<E> naya = new ArrayList<>();

        for (int i = ct - 1; i >= 0; i--) {

            naya.add(get(i));
        }
        return naya;
    }

    public ArrayList<E> subList(int fromIndex, int toIndex) {

        if (fromIndex <= toIndex && fromIndex >= 0 && toIndex < ct) {

            ArrayList<E> nayi = new ArrayList<>();

            for (int i = fromIndex; i < toIndex; i++) {
                nayi.add(get(i));
            }
            return nayi;
        }

        throw new IndexOutOfBoundsException("index not in range!");
    }

    public boolean equals(Object ref) {
        if (ref != null) {
            if (this.getClass() == ref.getClass()) {
                ArrayList<E> al = (ArrayList<E>) ref;
                if (this.ct == al.size()) {
                    for (int i = 0; i < ct; i++) {
                        if (!get(i).equals(al.get(i))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int hc = 0;
        for (int i = 0; i < ct; i++) {
            if (get(i) != null) {
                hc = (hc + get(i).hashCode());
            }
        }
        return hc;
    }

    public boolean removeDuplicates() {

        for (int i = 0; i < ct; i++) {

            for (int j = i + 1; j < ct; ) {

                if (ar[i].equals(ar[j])) {
                    remove(j);
                } else {
                    j++;
                }
            }
        }
		return false;
    }

    public void rotate(int k) {
        if (ct == 0) return;

        k = k % ct;
        if (k < 0) k += ct;

        Object[] temp = new Object[ct];
        int index = 0;

        for (int i = ct - k; i < ct; i++) {
            temp[index++] = ar[i];
        }

        for (int i = 0; i < ct - k; i++) {
            temp[index++] = ar[i];
        }

        ar = temp;
    }
}
