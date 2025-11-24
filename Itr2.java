package collectionImp;

import java.util.NoSuchElementException;

public class Itr2<E> implements Iterator{

	Node<E> head;
	Node<E> end;
	Node<E> curr;
	boolean flag;
	private boolean flag2;
	public Itr2(Node<E> head,Node<E> end) {
		this.head =head;
		this.end=end;
		curr = head;
	}
	
	public E next() {
		
		
		if (curr != null) {
			
			E ele = curr.ele;
			curr = curr.nextRef;
			return ele;
		}
		throw new NoSuchElementException();
	}
	
	public boolean hasNext() {
		return curr != null;
	}
	
	public E previous(){
		
		if (curr != null) {
			
			E ele = curr.ele;
			
			curr = curr.prevRef;
			
			return ele;
		}
		throw new NoSuchElementException();
	}
	
	public E previous(boolean rev) {
		
		if (curr == null) {
			
			curr = end;
			flag = true;
		}
		if (curr != null) {
			
			E ele = curr.ele;
			
			curr = curr.prevRef;
			
			return ele;
		}
		throw new NoSuchElementException();
	}
	
	public boolean hasPrevious() {
		
		return curr != null;

	}
}
