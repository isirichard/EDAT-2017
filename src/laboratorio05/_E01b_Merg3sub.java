package laboratorio05;
/**
 * b) Mergesort con 3 subconjuntos en lugar de 2. Quiere decir se subdivide hasta llegar a conjuntos
unitarios, luego se une de 3 en 3 para formar conjuntos ordenados.
 *
 */
public class _E01b_Merg3sub {
	public static void main(String[] args) {
		Comparable[]a={5,6,8,1,2,3,7,9,10,11};
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
		if(Math.abs(iu-ip)<=2) return; //caso de dos elementos
		int im1 = Math.abs((ip + iu)/3); //calcular índice de 1er tercio
		int im2 = Math.abs(((ip + iu)/3)*2); //calcular índice del 2do tercio
		mergesort(x,ip,im1); //ordenar 1ª mitad
		mergesort(x,im1+1,im2); //ordenar 2ª mitad
		mergesort(x,im2+1,iu); //ordenar 3ª mitad
		merge(x,ip,im1,im2,iu); //mezclar  3 mitades
	}
	static public void merge(Comparable[]x,int ip,int im1,int im2,int iu){
		Comparable menor=0;
		Object[]aux = new Object[iu+1]; //arreglo auxiliar
		int i1=ip, i2=im1+1,i3=im2+1, i=ip; //indices 1ª y 2ª y 3 mitad
		while(i1<=im1 && i2<=im2 && i3<=iu){ //hasta terminar una mitad
			menor=x[i1];
			if(x[i2].compareTo(menor)<0)menor=x[i2];
			if(x[i3].compareTo(menor)<0)menor=x[i3];
			if(menor==x[i1])aux[i++]=x[i1++];
			if(menor==x[i2])aux[i++]=x[i2++];
			if(menor==x[i3])aux[i++]=x[i3++];
		}
		if(i3-1==iu)
			while(i1<=im1 && i2<=im2){ //hasta terminar una mitad
				aux[i++] = x[i1].compareTo(x[i2])<0 ? x[i1++] : x[i2++];
			}
		else if(i1-1==im1)
			while(i2<=im2 && i3<=iu){ //hasta terminar una mitad
				aux[i++] = x[i2].compareTo(x[i3])<0 ? x[i2++] : x[i3++];
			}
		else if(i2-1==im2){
			while(i1<=im1 && i3<=iu){ //hasta terminar una mitad
				aux[i++] = x[i1].compareTo(x[i3])<0 ? x[i1++] : x[i3++];
			}
		}
		while( i1 <= im1 ) 
			aux[i++]=x[i1++]; //restantes 1ª mitad
		while( i2 <= im2 ) 
			aux[i++]=x[i2++]; //restantes 2ª mitad
		while( i3 <= iu ) 
			aux[i++]=x[i3++]; //restantes 3ª mitad
		for(int iz=ip; iz<=iu; ++iz) 
			x[iz]=(Comparable)aux[iz];//copiar
	}
	static void imprimir(Comparable[]arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
