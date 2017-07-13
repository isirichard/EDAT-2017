package laboratorio05;
/**
 * Solución 2. Con arreglo ordenado (descendentemente)
	 Insertar: O(n)
	 extraerMenor: O(1)
	 Ordenar: O(n2)
 *
 */
public class H2 {
	private Comparable[]a;
	private int n;
	public H2(int x){ a=new Comparable[x]; n=0; }
	public void insertar(Comparable x){
		int i;
		for(i=n; i>0 && a[i].compareTo(x)<0; --i)
			a[i]=a[i-1];
		a[i]=x; ++n;
	}
	public Comparable extraerMenor(){ return a[--n];}
}
