package laboratorio01;

public class InsercionV1 {
	public static void main(String args[]){
		int a []={5,6,7,8,9,4,11,2,1,0};
		int n=10;
		//Ordenar a [0],...,a[n-1] por inserción
		int k=0;
		//inicialmente no hay elementos ordenados
		int t=0; 
		int j=0;
		while(k<n){
			// Insertar a [k] entre a[0],...,a[k-1]
			//version optimizada del insersort
			 
			for(j =k;j>0&&a[j-1]>t;--j){
				t=a[j];
				a[j]=a[j-1];
				a[j-1]=t;
			}
			a[j]=t;
			//incremento
			++k;
		}
		// imprimir	
		for(int c=0;c<a.length;c++){
		System.out.print(a[c]+" ");	
		}
	}
}
/**
 * Construcción del primer ciclo
 * Relajar la meta separar en dos condiciones:
 * n==k && ordenar a[0],...,a[k-1] (k es el contador)
 * k<n; (k<=n)
 * inicializarlo k=0; (k=1)
 * k llegue hasta n-1 (n); condición de termino
 * cuerpo del ciclo; 
 * preservar la invariante (if o condición)
 * incremento
 * 
 */

/**
 * Construcción del segundo ciclo
 * j==k && insertar a[j] entre a[0],...a[j-1]
 * j>0&&j[j-1]>t
 * t=a[k]
 * --j;
 * a[j]=a[j-1]
 * a[j]=t;
 */
