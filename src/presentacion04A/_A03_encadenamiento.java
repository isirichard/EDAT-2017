package presentacion04A;
/*
 * Encadenamiento
 * Los elementos que caen en el mismo casillero se enlazan en una lista (que se recorre
 * secuencialmente).
 */
public class _A03_encadenamiento {
	static public final int m=10;
	public static void main(String[] args) {

		int[]a=new int[m];
		for(int i=0;i<m;++i) 
			a[i] = -1;
		int[]valor = {1,4,7,24,17,14,34};
		for(int j=0; j<valor.length; ++j){
			int i = h(valor[j]);
			while( a[i]>=0 && a[i]!=valor[j])
				i = (i + 1) % m;
			a[i] = valor[j];
		}
	}
	static public int h(int x){ return x % m;}
	
	
	/////BUSCAR/////
	static public Nodo buscar(int x, Nodo[]a){
		int i = h(x);
		if(a[i]==null) return null;//no está(Sup:a inic. c/null))
		for(Nodo r=a[i]; r!=null; r=r.sgte)
			if( r.valor == x ) return r;
		return null;
	}


	//Resultado: a={-1,1,-1,-1,4,24,14,7,17,34}
}
class Nodo{
	public int valor;
	public Nodo sgte;
	public Nodo(int x,Nodo y){ valor=x; sgte=y; }
}