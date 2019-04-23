package containers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> extends AbstractQueue<E> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	transient private E [] elements;
	private int head = 0;
	transient private int tail = 0;
	transient private int count = 0;
	private int modCount = 0; /* брояч на промените в данните */
	public ArrayQueue( int capacity ) {
		super();
		Object [] t = new Object[capacity];
		elements = (E[])t;
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeInt(count);
		E el;
		while( (el = poll()) != null ) {
			out.writeObject(el);
		}
		out.writeObject(null);
	}
	
	private void readObject( ObjectInputStream in) 
				throws ClassNotFoundException, IOException {
		in.defaultReadObject();
		int n = in.readInt();
		Object [] t = new Object[n];
		elements = (E[])t;
		E el;
		while( ( el =(E)in.readObject()) != null) {
			offer(el);
		}
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
		return elements[head];
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
			E elm = elements[ (head + offset) % elements.length];
			offset++;
			return elm;
		}
		
	}

}
