package presentacion04A;
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
	static int[]arr2={-1,1,-1,-1,4,-1,-1,7,-1,-1};
	public static void main(String[] args) {
		arrBooleano();
		
		System.out.println(h(1));
		System.out.println(h(9));
		
		//System.out.println("escribe: "+buscar(3,arr));
		System.out.println("escribe: "+buscar(7,arr2));
		System.out.println("escribe: "+buscar(4,arr2));
		System.out.println("escribe: "+buscar(24,arr2));
		
	}
	
	//ACCESO DE COMPLEJIDAD O(1)
	/////USANDO UN ARREGLO BOOLEANO////
	static void arrBooleano(){
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
			System.out.println("accedi en orden 1");
		}
		else{
			System.out.println("soy false");
		}
		//imprimir(a);
	}
	/////USANDO HASH//////
	static int h(int x){
		//para el modulo siempre hay una ubicación del 0-8
		return x%m;
	}
	/////BUSQUEDA//////
	static public int buscar(int x, int[]a){
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
			System.out.println(b);
		}

	}

	

}
