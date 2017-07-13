package presentacion02A;
//Clase Stack genérica
public class StackGE {
	private Object[]a;
	private int n;
	private static final int N=10;
	public StackGE(){
		n=0;
		a=new Object[N];
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
	public void push(Object x)throws StackFull{
		if(n>=N)
			throw new StackFull();
		a[n++]=x;
	}
	public Object pop()throws StackEmpty{
		if(n==0) 
			throw new StackEmpty("La lista no tiene elementos para quitar");
		return a[--n];
	}
}

