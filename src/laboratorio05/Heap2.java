package laboratorio05;

public class Heap2 {
	private Comparable[]a;
	private int n;
	public Heap2(Comparable[]x){ a=x; n=0; }
	public void insertar(Comparable x){
		a[++n]=x; //agregar al final
		for(int i=n; i>1; i=i/2){
			//terminar si hijo es menor que padre
			if( a[i].compareTo(a[i/2]) < 0 ) break;
			//intercambiar padre con hijo
			intercambiar(a,i,i/2);
		}
	}
	public Comparable extraerMayor(){
		//reemplazar raiz por ultimo
		Comparable aux=a[1]; a[1]=a[n--];
		//bajar el padre donde corresponda
		for(int i=1; 2*i<=n ; ){
			//determinar indice de hijo mayor
			int j=2*i;
			if(j+1<=n && a[j+1].compareTo(a[j])>0) ++j;
			//terminar si padre es mayor
			if( a[i].compareTo(a[j]) > 0 ) break;
			//intercambiar padre con hijo mayor
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
