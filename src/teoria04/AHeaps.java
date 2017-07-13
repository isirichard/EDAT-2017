package teoria04;

public class AHeaps {
	
	public void insertar(int x){
		int a[]=new int[10];
		int n=a.length;
		a[++n]=x;
		int t=0;
		for(int j=n; j>1 && a[j]>a[j/2]; j/=2){ 
			// intercambiamos con el padre
			t=a[j];
			a[j]=a[j/2];
			a[j/2]=t;
		}
	}
	public void eliminar(int m){
		int a[]=new int[10];
		int n=a.length;
		int t=0;
		int k=0;
		m=a[1]; // La variable m lleva el máximo
		a[1]=a[n--]; // Movemos el último a la raíz y achicamos el heap
		int j=1;
		while(2*j<n){ // mientras tenga algún hijo{
			k=2*j; // el hijo izquierdo
			if(k+1<=n && a[k+1]>a[k])
				k=k+1; // el hijo derecho es el mayor
				if(a[j]>a[k])
					break; // es mayor que ambos hijos
			t=a[j]; 
			a[j]=a[k];
			a[k]=t; 
			j=k; // lo intercambiamos con el mayor hijo
		}
	}
	

}
