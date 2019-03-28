package containers;

import java.util.AbstractQueue;
import java.util.Iterator;

public class ArrayQueue<E> extends AbstractQueue<E> {
	private Object [] elements;
	private int head = 0;
	private int tail = 0;
	private int count = 0;
	private int modCount = 0; /* брояч на промените в данните */
	public ArrayQueue( int capacity ) {
		super();
		elements = new Object[capacity];
	}
	
	@Override
	public boolean offer(E newElement) {
		if( newElement == null ) return false;
		if( count < elements.length ) {
			elements[tail] = newElement;
			tail = (tail + 1 ) % elements.length;
			count++;
			modCount++;
			return true;
		}
		return false;
	}

	@Override
	public E poll() {
		if( count == 0 ) return null;
		E ret = peek();
		elements[head] = null; //!!!!
		head = (head + 1) % elements.length;
		count--;
		modCount++;
		return ret;
	}

	@Override
	public E peek() {
		if( count == 0 ) return null;
		return (E)elements[head];
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return count;
	}

}
