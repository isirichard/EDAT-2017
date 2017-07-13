package laboratorio04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

////Búsqueda en arreglos
public class _A05_BusqArr {
	static int m=9;
	public static void main(String[] args) throws IOException {
		//HASH
		//¿Construcción del arreglo? Ejemplo:
		//contar número de elementos
		BufferedReader A=new BufferedReader(new FileReader("archivo.txt"));
		int n=0;
		while(A.readLine()!=null) 
			++n;
		//declarar arreglo 10% mas grande
		String[]a=new String[(int)(1.1*n+0.9)];
		//llenar arreglo usando función de hashing
		A=new BufferedReader(new FileReader("archivo.txt"));
		for(int j=1; j<=n; ++j){
			String linea = A.readLine();
			int i = hash(linea, a.length);
			System.out.print(j+" "+i+" - ");
			while( a[i]!=null && ! a[i].equals(linea))
				i = (i + 1) % a.length;
			a[i] = linea;
		}
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			System.out.println(i+"..."+a[i]);
		}
		System.out.println("buscando a Richard: "+buscar2("1, Richard",a));
	}
	//búsqueda hash
	static public int buscar2(Object x, Object[]a){
		int i=indiceH(x, a, a.length);
		if(a[i]==null) 
			return -1;//no está (Sup: a inicialmente con -1
		if(a[i].equals(x))
			return i; //está en indice i
		//... colisión (indice i está ocupado por otro valor)

		return -1;
	}
	
	
	static public int buscar(Object x, Object[]a){
		int i=indiceH(x, a, a.length);
		if((int)a[i]<0) 
			return -1;//no está (Sup: a inicialmente con -1
		if(a[i]==x)
			return i; //está en indice i
		//... colisión (indice i está ocupado por otro valor)

		return -1;
	}


	////Búsqueda secuencial o lineal.
	/**
	 * • Búsqueda O(n), es decir, realiza del orden de n comparaciones
	   • ¿Nº de comparaciones? Mínimo=1(mejor caso), Máximo=n(peor
		 caso),Promedio=n/2 (ej: 500 comparaciones para n=1000 elementos)
	 */
	static public int indiceL(Object x,Object[]y,int n){
		for(int i=0; i<n; ++i)
			if( y[i].equals(x) ) return i;
		return -1;
	}
	////Búsqueda secuencial o lineal recursiva
	static public int indiceR(Object x,Object[]y,int ip,int iu){
		if(ip>iu) return -1;
		return y[ip].equals(x)? ip : indiceR(x,y,ip+1,iu);
	}
	////Búsqueda secuencial o lineal concurrente
	static public int indiceC(Object x,Object[]y,int n) throws InterruptedException{
		int im=(n-1)/2;
		T t=new T(x,y,im,n-1);
		t.start();
		int i=indiceR(x,y,0,im);
		t.join();
		return i>=0 ? i : t.resultado();
	}

	////Búsqueda secuencial “optimizada” para arreglo ordenado (max=n/2 en promedio)
	static public int indiceO(Comparable x,Comparable[]y,int n){
		for(int i=0; i<n; ++i){
			int c = y[i].compareTo(x);
			if( c == 0 ) return i;
			if( c > 0 ) break;
		}
		return -1;
	}

	////Búsqueda binaria (para arreglo ordenado)
	/**
	 * Búsqueda O(log2n), es decir, realiza del orden de log2n comparaciones
       • ¿Nº de comparaciones? Mínimo=1, Máximo= log2n,Promedio=log2n /2 (ej: 10/2=5
	   comparaciones para n=1000 elementos)
	 */
	static public int indiceB(Comparable x,Comparable[]y,int n){
		int ip=0, iu=n-1, im, c;
		while(ip <= iu){
			if((c=y[im=(ip+iu)/2].compareTo(x))== 0) return im;
			if(c>0) iu=im-1; else ip=im+1;
		}
		return -1; //no está
	}
	//Búsqueda por Hashing: para arreglos no ordenados “grandes” (“una comparación”)
	/**
	 * Idea: aplicar una función al argumento de búsqueda que produzca entero entre 0 y n-1
	   • La función, f(x) → [0,n[, debe diseñarse de modo que distribuya sus argumentos
  	    en distintas posiciones.
	   • Si se producen “colisiones”, es decir, si f(x)=f(y), entonces una solución es
	    ubicar x en la próxima posición disponible (rehashing lineal).
	   • Es importante que el arreglo tenga más elementos que los valores posibles,
		y de preferencia que sea un Nº primo.
	 */
	static public int indiceH(Object x,Object[]y,int n){
		for(int i=hash(x,n); y[i]!=null; i=(i+1)%n)
			if( y[i].equals(x) ) return i;
		return -1;
	}
	protected static int hash(Object x,int n){
		return Math.abs(x.hashCode()%n);
	}
	
}
class T extends Thread{
	private Object x,y[]; 
	private int ip, iu, i;
	public T(Object x,Object[]y,int ip,int iu){
		this.x=x; 
		this.y=y; 
		this.ip=ip; 
		this.iu=iu;
	}
	
	public void run(){ 
		//i=indice(a,ip,iu); 
		//i=indice
	}
	public int resultado(){ 
		return i; 
	}
}

