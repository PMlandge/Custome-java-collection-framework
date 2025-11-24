package collectionImp;

public interface Deque<E> {
	
	void addFirst (E ele);
	
	void addLast (E ele) ;
	
	boolean offerFirst(E e) ;
	
	boolean offerLast(E e) ;
	
	E element() ;
	
	E getFirst() ;
	
	E getLast () ;
	
	E peekFirst() ;
	
	E peekLast() ;
	 
	E poll () ;
	
	E pollFirst() ;
	
	E pollLast();
	
	E removeFirst() ;
	
	E removeLast();
	
	E pop();
	
	void push(E ele);
	
	int size() ;	

}
