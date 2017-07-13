package presentacion02A;

public class StackArr {
	protected String[]a;
	protected int n;
	protected int N=100;
	public StackArr(){
		a=new String[N];
		n=0;
	}
	/*
	public void push(String x){
		a[n+1]=x;
	}
	*/
	public void push(String x)
	{
	 	if (n<N) // si esta llena se produce OVERFLOW
		 {
	 		a[n++]=x;
		 }
		 else
		 {
			 N=N*2;
			 String[] nuevo_arreglo=new String[N];
			 for (int i=0; i<a.length; i++)
			 {
				 nuevo_arreglo[i]=a[i];
			 }
			 n++;
			 nuevo_arreglo[n]=x;
			 a=nuevo_arreglo;
		 }
	}
	
	public String pop(){
		return a[--n];
	}
	public boolean empty(){
		return n==0;
	}
	public boolean full(){
		return n>=N;
	}
	public void reset(){
		n=0;
	}
}
