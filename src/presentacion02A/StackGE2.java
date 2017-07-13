package presentacion02A;

import java.lang.reflect.Array;

//Clase Stack genérica T
public class StackGE2<T> {
	private T[]a;
	private int n;
	private static final int N=10;
	public StackGE2(){
		n=0;
		//a=new T[N];
		a=(T[]) new Object[N];
	}
	public void reset(){
		n=0;
	}
	public boolean empty(){
		return n==0;
	}
	public boolean full(){
		return n>=N;
	}
	public void push(T x)throws StackFull{
		if(n>=N)
			throw new StackFull();
		a[n++]=x;
	}
	public T pop()throws StackEmpty{
		if(n==0) 
			throw new StackEmpty("La lista no tiene elementos para quitar");
		return a[--n];
	}

}
