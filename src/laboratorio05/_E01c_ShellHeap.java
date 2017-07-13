package laboratorio05;
/**
 * c) Shellsort y Heapsort.
 *
 */
public class _E01c_ShellHeap {
	public static void main(String[] args) {
		System.out.println("Shellsort");
		Comparable[]a={5,6,7,1,2,3,9,4};
		shellsort(a,a.length);
		imprimir(a);
		System.out.println("Heapsort");
		Comparable[]a2={5,6,7,1,2,3,9,4};
		heapsort(a2,a2.length);
		imprimir(a2);
	}
	static public int heapsort(Comparable[]x, int n){
		Heap h= new Heap(n);
		for(int i=0; i<n; ++i) h.insertar(x[i]);
		for(int i=0; i<n; ++i) x[i]=h.extraerMenor();
		return -1;
	}
	static public void shellsort(Comparable[]x,int n){
		if( n < 2 ) return;
		for(int d=n/2; d>0; d=d/2) //distancia entre elementos
			for(int i=d; i<n; ++i){
				//insertar x[i] entre anteriores a distancia d
				Comparable aux = x[i];
				int j;
				for(j=i; j>=d && x[j-d].compareTo(aux)>0; j-=d)
					x[j] = x[j-d];
				x[j] = aux;
			}
	}
	static void imprimir(Comparable[]arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
