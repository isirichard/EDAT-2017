package laboratorio05;

public class H {
	private Comparable[]a;
	private int n;
	public H(int x){ a=new Comparable[x]; n=0; }
	public void insertar(Comparable x){ a[n++]=x; }
	public Comparable extraerMenor(){
		int im=0;
		for(int i=1; i<n; ++i)
			if( a[i].compareTo(a[im])<0 ) im=i;
		Comparable aux = a[im];
		a[im]=a[--n];
		return aux;
	}
}
