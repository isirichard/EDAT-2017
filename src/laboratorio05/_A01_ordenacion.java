package laboratorio05;
//Problema. Ordenar un arreglo de n elementos.
public class _A01_ordenacion {
	public static void main(String[] args) {
		Comparable[]a={5,6,7,1,2,3,9,4};
		ord1(a);
		imprimir(a);
		ord12(a);
		imprimir(a);
		ord13(a,a.length);
		imprimir(a);
		ord2(a,a.length);
		imprimir(a);
		ord21(a,a.length);
		imprimir(a);
		ord3(a,a.length);
		imprimir(a);
	}
	/**
	 * Solución 1. Algoritmo de selección y reemplazo/intercambio
	 * Repetir n veces
	 • seleccionar el menor
	 • intercambiar menor con el primero

	 */
	static void ord1(Comparable[]arr){
		int aux=0;
		int n=arr.length;
		//repetir n veces
		for(int ip=0; ip<n; ++ip){//para índice primero=0,1,...,n-1
			//seleccionar el (indice del) menor
			int im = ip;
			for(int i=ip+1; i<n; ++i)
				if(arr[i].compareTo(arr[im]) < 0) 
					im = i;
			//intercambiar menor con el primero
			aux=(int)arr[ip]; 
			arr[ip]=arr[im]; 
			arr[im]=aux;

		}
	}
	//Versión 2 (“simétrica”)
	/**
	 * Repetir n veces
	 • seleccionar el mayor
	 • intercambiar mayor con el último
	 */
	static void ord12(Comparable[]arr){
		int n=arr.length;
		//repetir n veces
		for(int l=n; l>0; --l){ //para largo=n,n-1,...,1
			//seleccionar el (indice del) mayor
			int im = indiceMayor(arr,l);
			//intercambiar mayor con último
			intercambiar(arr,im,l-1);
		}
	}
	//¿recursivo?
	static void ord13(Comparable[]arr,int n){
		if( n < 2 ) return;
		intercambiar(arr, indiceMayor(arr,n), n-1);
		//ordenar(arr, n-1);
		ord13(arr,n-1);
	}
	/**
	 * Solución 2. Algoritmo de la burbuja
	 * ¿Idea? En cada una de las pasadas “hacer subir la burbuja (el mayor) al último lugar”.
	 * repetir n veces:
	 • recorrer cada elemento
	 • comparar con elemento siguiente
	 • intercambiar si están fuera de orden (“hacer subir la burbuja”)
	 */
	static void ord2(Comparable[]arr,int n){
		if( n < 2 ) return;
		for(int i=0; i<n-1; ++i)
			if(arr[i].compareTo(arr[i+1]) > 0)
				intercambiar(arr,i,i+1);
		//ordenar(arr,n-1);
		ord2(arr,n-1);
	}
	//Versión 2. si en una pasada no se realizan intercambios, entonces el arreglo está ordenado.
	static void ord21(Comparable[]arr,int n){
		if( n < 2 ) return;
		boolean ordenado=true;
		for(int i=0; i<n-1; ++i)
			if(arr[i].compareTo(arr[i+1]) > 0){
				intercambiar(arr,i,i+1); 
				ordenado=false;
			}
		if(!ordenado) ord21(arr,n-1);
	}
	/**
	 * Solución 3. Algoritmo de inserción
	 ¿idea? Cada vez se inserta un elemento entre los ya ordenados.
	 */
	static void ord3(Comparable[]arr){
		ord3(arr,arr.length);
	}
	static void ord3(Comparable[]arr,int n){
		if( n < 2 ) return;
		for(int i=1; i<n; ++i){
			//insertar x[i] entre x[0],...,x[i-1]
			Comparable aux = arr[i];
			int j;
			for(j=i; j>0 && arr[j-1].compareTo(aux)>0; --j)
				arr[j] = arr[j-1];
			arr[j] = aux;
		}
	}
	static int indiceMayor(Comparable[]arr,int l){
		int iM = l-1;
		for(int i=l-2; i>0; --i)
			if(arr[i].compareTo(arr[iM]) > 0) 
				iM = i;
		return iM;
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
