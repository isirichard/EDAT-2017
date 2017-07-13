package presentacion04A;
/**
 * Resolución de colisiones
 * Redireccionamiento abierto (intentar con otra función de hash)
 * Encadenamiento (usar estructuras dinámicas)
 */
public class _A02_colisiones {
	static int[]arr2={-1,1,-1,-1,4,-1,-1,7,-1,-1};
	static int m=arr2.length;
	public static void main(String[] args) {


	}

	/*Redireccionamiento abierto
	 * Se dispone de una sucesión de funciones de hash: h0(x), h1(x), ...
	 * Primero se intenta con h0(x), Si casillero está ocupado se prueba con h1(x), y así
	 * sucesivamente.
	 */
	static public int h0(int x){ return 0; }
	static public int h1(int x){ return 0; }
	static public int buscar(int x, int[]a){
		int i = h0(x);
		if(a[i]<0) return -1; //no está(Sup:a inicialmente con –1)
		if(a[i]==x) return i; //está en índice i
		i = h1(x);
		if(a[i]<0) return -1; //no está(Sup:a inicialmente con –1)
		if(a[i]==x) return i; //está en índice i
		//...
		return -1;
	}
	/*
	 * Linear probing (rehashing lineal)
	 * h0(x) = h(x)
	 *  h i+1(x) = (hi(x)+1) % m
	 */
	static public int h(int x){ return x % m;}
	static public int buscar2(int x,int[]a){
		int i = h(x); //h0
		while(a[i]>=0){
			if(a[i]==x) return i;
			i = (i+1) % m; //h1,h2,...
		}
		return -1;
	}
	//Nota. Cuando la tabla de hashing está muy llena, este método resulta muy lento:
	
	
	

	}
