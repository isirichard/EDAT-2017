package laboratorio05;
/**
 * • 1959, Donald Shell: O(n 3/2) y O(n2) en peor caso
	 • se comparan primero elementos distantes, después más cercanos ( a mitad de la
	 distancia anterior), y finalmente los que están a distancia 1 (inserción)
	 • ordenación por disminución de distancias (intervalos)
	 • generalización de inserción
 *
 */
public class _A06_Shellsort {
	public static void main(String[] args) {
		Comparable[]a={5,6,7,1,2,3,9,4};
		shellsort(a,a.length);
		imprimir(a);
	}
	static public void inserción(Comparable[]x,int n){
		if( n < 2 ) return;
		for(int i=1; i<n; ++i){
			//insertar x[i] entre x[0],...,x[i-1]
			Comparable aux = x[i];
			int j;
			for(j=i; j>0 && x[j-1].compareTo(aux)>0; --j)
				x[j] = x[j-1];
			x[j] = aux;
		}
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
