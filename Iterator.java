package collectionImp;

public interface Iterator<E> {
    E next();
    boolean hasNext();
    
    E previous();
    E previous(boolean flag) ;
    boolean hasPrevious();
}
