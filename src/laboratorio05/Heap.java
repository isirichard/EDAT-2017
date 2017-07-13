package laboratorio05;
/**
 * Solución 3. Con heap
insertar: O(logn)
extraerMenor: O(logn)
ordenar: O(nlogn) incluso en peor caso
 *
 */
public class Heap {
	private Comparable[]a;
	private int n;
	public Heap(int x){ a=new Comparable[x+1]; n=0; }
	public void insertar(Comparable x){
		a[++n]=x; //agregar al final
		for(int i=n; i>1; i=i/2){
			//terminar si hijo es mayor que padre
			if( a[i].compareTo(a[i/2]) > 0 ) break;
			//intercambiar padre con hijo
			intercambiar(a,i,i/2);
		}
	}
	public Comparable extraerMenor(){
		//reemplazar raiz por ultimo
		Comparable aux=a[1]; a[1]=a[n--];
		//bajar el padre donde corresponda
		for(int i=1; 2*i<=n ; ){
			//determinar indice de hijo menor
			int j=2*i;
			if(j+1<=n && a[j+1].compareTo(a[j])<0)
				++j;
			//terminar si padre es menor
			if( a[i].compareTo(a[j]) < 0 ) 
				break;
			//intercambiar padre con hijo menor
			//???Ordenamiento.intercambiar(a,i,j);
			intercambiar(a,i,j);
			//actualizar indice de padre
			i=j;
		}
		//devolver raiz
		return aux;
	}
	static void intercambiar(Comparable[]arr, int iM, int l){
		int aux=0;
		aux=(int)arr[l]; 
		arr[l]=arr[iM]; 
		arr[iM]=aux;
	}
}
