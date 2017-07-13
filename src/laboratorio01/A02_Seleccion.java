package laboratorio01;

public class A02_Seleccion {
	public static void main(String args[]){
		//long inicio=System.nanoTime();
		//Ordenar a[0],...,a[n-1] por selección k=n;
		int a []={5,6,7,8,9,4,11,2,1,0};
		int k=10;
		//inicialmente los n primeros estan desordenados
		int i=0;
		int t=0;
		while (k>=2){
			//llevar el max de a[0],..., a[k-1] hacia a a[k-1];
			i=0;
			for(int j=1;j<=k-1;++j){
				if(a[j]>a[i])
					i=j;
			}
			//ahora intercambiamos a[i] con a[k-1]
			t=a[i];
			a[i]=a[k-1];
			a[k-1]=t;
			//disminuir
			--k;
		}
		//Impresion
		System.out.println("Selección:");
		for(int c=0;c<a.length;c++){
			System.out.print(a[c]+" ");	
		}
		/*
		long fin = System.nanoTime();
		System.out.println();
		System.out.print("tiempo en nano: ");
		System.out.println(fin-inicio);
		*/
	}
}
