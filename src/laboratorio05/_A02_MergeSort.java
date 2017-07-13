package laboratorio05;
/**
 * MergeSort
 *
 */
public class _A02_MergeSort {
	public static void main(String[] args) {
		Comparable[]a={5,6,7,1,2,3,9,4};
		mergesort(a,0,a.length-1);
		imprimir(a);
	}
	/**
	 * situación inicial desordenada desordenada
	 ordenar mitades ip im iu
	 situación intermedia
	 mezclar (“merge”)
	 situación final
	 */
	static public void mergesort(Comparable[]x, int ip, int iu){
		if(ip >= iu) return; //si 1 elemento, está ordenado
		int im = (ip + iu)/2; //calcular índice de mitad
		mergesort(x,ip,im); //ordenar 1ª mitad
		mergesort(x,im+1,iu); //ordenar 2ª mitad
		merge(x,ip,im,iu); //mezclar mitades
	}
	static public void merge(Comparable[]x,int ip,int im,int iu){
		Object[]aux = new Object[iu+1]; //arreglo auxiliar
		int i1=ip, i2=im+1, i=ip; //indices 1ª y 2ª mitad
		while(i1<=im && i2<=iu) //hasta terminar una mitad
			aux[i++] = x[i1].compareTo(x[i2])<0 ? x[i1++] : x[i2++];
		while( i1 <= im ) 
			aux[i++]=x[i1++]; //restantes 1ª mitad
		while( i2 <= iu ) 
			aux[i++]=x[i2++]; //restantes 2ª mitad
		for(int iz=ip; iz<=iu; ++iz) 
			x[iz]=(Comparable)aux[iz];//copiar
	}
	static public void merge2(Comparable[]x,int ip,int im,int iu){
		//mezclar en arreglo auxiliar
		Object[]aux = new Object[iu+1]; //arreglo auxiliar
		for(int i=ip, i1=ip, i2=im+1; i<=iu; ++i)
			if(i1<=im && (i2>iu || x[i1].compareTo(x[i2])<0))
				aux[i] = x[i1++];
			else
				aux[i] = x[i2++];
		//copiar arreglo auxiliar en arreglo original
		for(int i=ip; i<=iu; ++i) x[i]=(Comparable)aux[i];
	}
	static void imprimir(Comparable[]arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
