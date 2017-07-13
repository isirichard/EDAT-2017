package laboratorio05;

public class _A03_QuickSort {
	public static void main(String[] args) {
		Comparable[]a={5,6,7,1,2,3,9,4};
		quicksort(a,0,a.length-1);
		imprimir(a);
	}
	static public void quicksort(Comparable[]x,int ip,int iu){
		if(ip >= iu) return; //si 1 elemento, está ordenado
		int i = particionar(x,ip,iu); //particionar
		quicksort(x,ip,i-1); //ordenar 1ª parte
		quicksort(x,i+1,iu); //ordenar 2ª parte
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
	static public int particionar2(Comparable[]x,int ip,int iu){
		Comparable pivote = x[ip];
		int i=ip+1,j=iu;//indices de menores(izq) y mayores(der)
		while(true){
			while( i<=j && x[i].compareTo(pivote)<0 ) 
				++i;
			while( i<=j && x[j].compareTo(pivote)>=0 ) 
				--j;
			if( i>j ) 
				break;
			intercambiar(x,i++,j--);
		}
		intercambiar(x,ip,j);
		return j;
	}
	/**
	 * Mejoras a Quicksort
	 Elemento central como pivote
	 • El peor caso de quicksort se produce si arreglo ya está ordenado: O(n2)
	 • Una mejor elección es tomar el elemento central
	 • Si arreglo está ordenado, el pivote es el óptimo
	 */
	int particionar3(Comparable[]x, int ip, int iu){
		intercambiar(x,(ip+iu)/2,ip);//pivote es el central
		Comparable pivote=x[ip];
		int i = ip; //indice de ultimo de menores que pivote
		for(int j=ip+1; j<=iu; ++j)
			if( x[j].compareTo(pivote) < 0 )
				intercambiar(x,++i,j);
		intercambiar(x,ip,i);
		return i;
	}
	void intercambiar(Object[]x, int i, int j){
		Object aux=x[i]; x[i]=x[j]; x[j]=aux;
	}
	/*
	 * Pivote con mediana de 3
	 • Pivote se elige como la mediana de una muestra de 3 elementos.
	 • Si se escoge primero, último y medio, entonces el peor caso (arreglo ordenado) que
	 toma tiempo O(n2) se transforma en mejor caso( O(nlogn))
	 • Una mejor elección del pivote que se acerca más a la mediana de todos los
	 elementos se lograría con una mediana de una muestra de 5, 7, 9, ... elementos
	 */
	int particionar4(Comparable[]x, int ip, int iu){
		int im = indiceMediana(x,ip,iu,(ip+iu)/2);
		intercambiar(x,im,ip); //pivote a primer índice
		Comparable pivote=x[ip];
		int i = ip; //indice de ultimo de menores que pivote
		for(int j=ip+1; j<=iu; ++j)
			if( x[j].compareTo(pivote) < 0 )
				intercambiar(x,++i,j);
		intercambiar(x,ip,i);
		return i;
	}
	int indiceMediana(Comparable[]x,int i,int j,int k){
		if( x[i].compareTo(x[j])<=0 && x[j].compareTo(x[k])<=0 )
			return j;
		if( x[i].compareTo(x[k])<=0 && x[k].compareTo(x[j])<=0 )
			return k;
		return i;
	}
	/**
	 * Ordenación por inserción para sub-arreglos pequeños
	 • No es eficiente ordenar recursivamente arreglos pequeños
	 • Los arreglos de tamaño inferior a M (por ejemplo 10) se ordenan por inserción
	 */
	void quicksort2(Comparable[]x, int ip, int iu){
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
	void ordenar(Comparable[]x, int ip, int iu){
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
	/*
	 * Alternativamente
	 • No ordenar subarreglos pequeños
	 • Al final, se tiene arreglo con pivotes que están en orden creciente que encierran
	 bloques pequeños de elementos desordenados
	 • La ordenación debe completarse con una sóla gran pasada de ordenación por
	 inserción que tiene un costo O(nM) y no O(n2), porque ningún elemento está a una
	 distancia mayor que M de su ubicación definitiva
	 */
	void quicksort3(Comparable[]x, int ip, int iu){
		int M=10;
		if(ip >= iu) return; //si 1 elemento, está ordenado
		if( iu-ip < M ) return;//no ordenar subarreglos pequeños
		int i = particionar(x,ip,iu); //particionar
		quicksort3(x,ip,i-1);
		quicksort3(x,i+1,iu);
	}
	void quicksort4(Comparable[]x, int ip, int iu){
		quicksort3(x,ip,iu);
		ordenar(x,ip,iu);
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
