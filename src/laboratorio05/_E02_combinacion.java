package laboratorio05;
/**
 * 2. Implementa un Algoritmo de ordenación eficiente donde combines 2 o más algoritmos de ordenación
conocidos, con el objetivo de mejorar aún más la eficiencia del resultado.
 *
 */
public class _E02_combinacion {
	public static void main(String[] args) {
		Comparable[]a={5,6,7,1,2,3,9,4,8,10,11};
		quicksort2(a,0,a.length-1);
		imprimir(a);
	}
	static void quicksort2(Comparable[]x, int ip, int iu){
		int M=10;
		if(ip >= iu) return; //si 1 elemento, está ordenado
		if( iu-ip < M ){
			ordenar(x,ip,iu);
			return;
		}
		int i = particionar(x,ip,iu); //particionar
		quicksort2(x,ip,i-1); //ordenar 1ª parte
		quicksort2(x,i+1,iu); //ordenar 2ª parte
	}
	static public int particionar(Comparable[]x,int ip,int iu){
		Comparable pivote = x[ip];
		int i = ip; //indice de ultimo de menores que pivote
		for(int j=ip+1; j<=iu; ++j)
			if( x[j].compareTo(pivote) < 0 )
				intercambiar(x,++i,j);
		intercambiar(x,ip,i);
		return i;
	}
	static void ordenar(Comparable[]x, int ip, int iu){
		if( ip >= iu ) return;
		for(int i=ip+1; i<=iu; ++i){
			//insertar x[i] entre x[ip],...,x[i-1]
			Comparable aux = x[i];
			int j;
			for(j=i; j>ip && x[j-1].compareTo(aux)>0; --j)
				x[j] = x[j-1];
			x[j] = aux;
		}
	}
	static void intercambiar(Comparable[]arr, int iM, int l){
		int aux=0;
		aux=(int)arr[l]; 
		arr[l]=arr[iM]; 
		arr[iM]=aux;
	}
	static void imprimir(Comparable[]arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
