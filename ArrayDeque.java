package collectionImp;

import java.util.NoSuchElementException;

public class ArrayDeque<E> implements Deque<E>  {

	private int ct = 0 ;
	private Object [] ar ;
	private int initialCap = 16 ;
	
	public ArrayDeque()
	{
		ar = new Object[initialCap] ;
	}
	
	public ArrayDeque(int initial)
	{
		ar = new Object [initial];
	}
	
	public void addFirst(E ele )
	{
		if(ele == null )
		{
			throw new NullPointerException();
		}
		else if(ct <0.75 * ar.length)
		{
			if(ct== 0)
			{
				ar[0] = ele ;
				ct++ ;
			}
			else {
				for(int i = ct ; i>0 ; i--)
				{
					ar[i] = ar[i-1 ];
				}
				ar[0] = ele ;
				ct++ ;
			}
		}
		else {
			grow() ;
		
			for(int i = ct ; i> 0; i-- )
			{
				ar[i] = ar[i-1] ;
			}
			ar[0] = ele ;
			ct++ ;
		}
	}
	
	public void addLast(E ele)
	{
		if(ele == null )
		{
			throw new NullPointerException();
		}
		else if(ct < 0.75 * ar.length)
		{
			ar [ct] = ele ;
			ct ++;
		}
		else {
			grow();
			ar[ct] = ele ;
			ct++ ;
		}
	}
	
	public E removeLast()
	{
		if(ct> 0)
		{
			ct-- ;
			return (E) ar[ct] ;
		}
		throw new NoSuchElementException("Queue is empty ");
	}

	public E removeFirst()
	{
		if(ct > 0)
		{
			E val = (E) ar[0];
			
			for(int i = 0 ; i < ct-1 ; i++)
			{
				ar[i] = ar[i+1];
			}
			ct--;
			return val;
		}
		throw new NoSuchElementException("Queue is empty");
	}

	public E getFirst()
	{
		if(ct== 0 )
		{
			throw new NoSuchElementException("Queue is empty ");
		}
		else {
			return (E) ar[0] ;
		}
	}

	public E getLast()
	{
		if(ct== 0 )
		{
			throw new NoSuchElementException("Queue is empty ");
		}
		else {
			return (E) ar[ct-1] ;
		}
	}
	
	public boolean offerFirst(E ele)
	{
		addFirst(ele) ;
		return true ;
	}

	public boolean offerLast(E ele)
	{
		addLast(ele) ;
		return true ;
	}
	
	public E pollFirst()
	{
		try {
			return removeFirst() ;
		}
		catch(NoSuchElementException e){
			
			return null ;
		}
	}
	
	public E pollLast()
	{
		try {
			return  removeLast();
		}
		catch(NoSuchElementException e)
		{
			return null ;
		}
	}
	
	public E peek()
	{
		try {
			return getFirst();
		}
		catch(NoSuchElementException e)
		{
			return null ;
		}
	}
	
	public E peekFirst()
	{
		try {
			return getFirst();
		}
		catch(NoSuchElementException e)
		{
			return null ;
		}
	}

	public E peekLast()
	{
		try {
			return getLast();
		}
		catch(NoSuchElementException e)
		{
			return null ;
		}
	}
	
	public boolean add(E ele)
	{
		addLast(ele);
		return true ;
	}

	public E element ()
	{
		return getFirst();
	}

	public boolean offer(E ele)
	{
		return offerLast(ele);
	}

	public E poll ()
	{
		return pollFirst();
	}

	@Override
	public void push(E e) {
	    addFirst(e);
	}

	@Override
	public E pop() {
	    return removeFirst();
	}


	public int size()
	{
		return ct ;
	}

	public E remove()
	{
		return removeFirst();
	}

	public boolean contains(E ele)
	{
		for (int i=0 ; i< ct ; i++)
		{
			if(ar[i].equals(ele))
			{
				return true ;
			}
		}
		return false ;
	}
	
	private void grow()
	{
		Object [] temp = new Object[ar.length*2];
		for(int i = 0 ;i<ct ; i++ )
		{
			temp [i] = ar[i];
		}
		ar = temp ;
	}
	
	public String toString ()
	{
		StringBuilder sb = new StringBuilder ("[")	;
		for(int i=0 ; i<ct ; i++)
		{
			if(i<ct-1)
			{
				sb.append(ar[i]+",");
			}
			else {
				sb.append(ar[i]);
			}
		}
		sb.append("]");
		return new String (sb);
	}
}
