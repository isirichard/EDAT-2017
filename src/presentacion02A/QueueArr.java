package presentacion02A;

public class QueueArr {
	protected Object[]a;
	protected int n, ip, iu;
	protected static final int N=100;
	public QueueArr(){
		a=new Object[N];
		n=0;
		ip=0;
		iu=-1;
	}
	public void enque (Object x) throws QueueFull{
		if(n>=N)
			throw new QueueFull();
		iu=(iu+1)%N;
		a[iu]=x;
		++n;
	}
	public Object deque() throws QueueFull, QueueEmpty{
		if(n==0)
			throw new QueueEmpty();
		Object aux=a[ip];
		ip=(ip+1)%N;
		--n;
		return aux;
	}
	public boolean empty(){
		return n==0;
	}
	public boolean full(){
		return n>=N;
	}
	public void reset(){
		n=0;
		ip=0;
		iu=-1;
	}
}
