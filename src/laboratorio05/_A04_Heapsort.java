package laboratorio05;
/**
 * Problema. Usar una clase H con los métodos insertar(x) y extraerMenor() para ordenar
	un arreglo.
 *	Solución 1. Con arreglo desordenado
	 insertar: O(1)
	 extraerMenor: O(n)
	 ordenar: O(n2)
 */
public class _A04_Heapsort {
	public static void main(String[] args) {
		Comparable[]a={5,6,7,1,2,3,9,4};
		heapsort(a,a.length);
		imprimir(a);
	}
	static public void ordenar(Comparable[]x, int n){
		H h= new H(n);
		for(int i=0; i<n; ++i) h.insertar(x[i]);
		for(int i=0; i<n; ++i) x[i]=h.extraerMenor();
	}
	static public int heapsort(Comparable[]x, int n){
		Heap h= new Heap(n);
		for(int i=0; i<n; ++i) h.insertar(x[i]);
		for(int i=0; i<n; ++i) x[i]=h.extraerMenor();
		return -1;
	}
	static public void heapsort2(String[]x, int n){
		Heap2 h= new Heap2(x);
		for(int i=1; i<n; ++i) h.insertar(x[i]);
		for(int i=n-1; i>=1; --i) x[i]=(String)h.extraerMayor();
		}
	static void imprimir(Comparable[]arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
