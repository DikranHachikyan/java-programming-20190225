package containers;

import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> extends AbstractQueue<E> {
	private E [] elements;
	private int head = 0;
	private int tail = 0;
	private int count = 0;
	private int modCount = 0; /* брояч на промените в данните */
	public ArrayQueue(Class<E> c,   int capacity ) {
		super();
		//1.
		//elements = new Object[capacity];
		// това е грешка
		//elements = new E[capacity];
		//2.
		elements = (E[])Array.newInstance(c, capacity);
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
		return new QueueIterator();
	}

	@Override
	public int size() {
		return count;
	}
	
	private class QueueIterator implements Iterator<E>{
		private int offset = 0;
		private int expectedModCount = modCount;
		
		@Override
		public boolean hasNext() {
			if( modCount != expectedModCount) {
				throw new ConcurrentModificationException();
			}
			return offset < count;
		}

		@Override
		public E next() {
			if( ! hasNext()) throw new NoSuchElementException();
			E elm = (E)elements[ (head + offset) % elements.length];
			offset++;
			return elm;
		}
		
	}

}
