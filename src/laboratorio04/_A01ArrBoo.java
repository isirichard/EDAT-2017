package laboratorio04;
/**
 * Problema. Agregar, borrar y buscar enteros en el rango [0,k[
 *	Solución. Arreglo de booleans
 *  Solución 2. Hashing: método de búsqueda de orden 1 (O(1))
 */
public class _A01ArrBoo {
	static int k=9;
	static int m=9;
	static boolean[]a=new boolean[k];
	static int[]arr=new int[m];

	public static void main(String[] args) {
		System.out.println("/////usando un arreglo de booleanos");
		boolean[]arr=arrBooleano();
		if(arr[7])
			System.out.println("accediendo a arr[7]... O(1)");
		System.out.println("/////usando hash");
		int[]arr2=hashing();
		System.out.println("accediendo con funcion h 7... "+buscar(7,arr2));
		
	}
	
	//ACCESO DE COMPLEJIDAD O(1)
	/////USANDO UN ARREGLO BOOLEANO////
	static boolean[] arrBooleano(){
		int k=9;
		boolean[]a=new boolean[k];
		//agregar 1,4,7
		a[1]=true;
		a[4]=true;
		a[7]=true;
		//borrar
		a[4]=false;
		//buscar 7 acceso
		
		if(a[7]){
			//System.out.println("accedi en orden 1");
		}
		else{
			//System.out.println("soy false");
		}
		imprimir(a);
		return a;
		//imprimir(a);
	}
	/////USANDO HASH//////
	static int[] hashing(){
		int[]arr2={-1,1,-1,-1,4,-1,-1,7,-1,-1};
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]+" ");
		}
		return arr2;
	}
	static int h(int x){
		//para el modulo siempre hay una ubicación del 0-8
		return x%m;
	}
	/////BUSQUEDA//////
	static public int buscar(int x, int[]a){
		System.out.println();
		int i=h(x);
		if(a[i]<0) 
			return -1;//no está (Sup: a inicialmente con -1
		if(a[i]==x)
			return i; //está en indice i
		//... colisión (indice i está ocupado por otro valor)
		
		return -1;
	}
	
	//imprimir arreglo booleando////
	static void imprimir(boolean[]arr){
		for (boolean b : arr) {
			System.out.print(b+" ");
		}
		System.out.println();

	}

	

}
