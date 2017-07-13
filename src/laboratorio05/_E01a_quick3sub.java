package laboratorio05;
//En grupos de 2 personas desarrolla los siguientes ejercicios:
/**
 * 1. Implemente Algoritmos de Ordenación:
 * a) Quicksort con 3 subconjuntos en lugar de 2. Quiere decir que cada pasada se escoge a 2 pivotes que
se mueven dejando valores 0..i < p1 < i..j < p2 < j..n
 *
 */
public class _E01a_quick3sub {
	public static void main(String[] args) {
		Comparable[]a={5,6,7,1,2,3,9,4};
		quicksort(a,0,a.length-1);
		imprimir(a);
	}
	static public void quicksort(Comparable[]x,int ip,int iu){
		if(ip >= iu) return; //si 1 elemento, está ordenado
		int im=(ip+iu+1)/2;
		int p1 = particionar(x,ip,im); //particionar
		int p2 = particionar(x,im,iu); //particionar
		quicksort(x,ip,p1-1); //ordenar 1ª parte
		quicksort(x,p1,p2); //ordenar 2ª parte
		quicksort(x,p2+1,iu);
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
