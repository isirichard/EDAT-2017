package presentacion01E;
/**
 * 1) Utilizando un diagrama de estados. Reordenar los elementos de a[0],...,a[n]
 * dejando a la izquierda los <0 y a la derecha los >=0. Resuelve este problema
 * de 3 formas diferentes.
 */
public class E1_izqder {

	public static void main(String[]args){
		R3();		
	}
	/* PRIMERA FORMA
	 * Reordenar los elementos de un arreglo
	 */	
	public static void R1(){
		int[]a={1,2,3,-2,0,-4,-5};
		final int n=a.length; // n
		int i=0;
		int j=n-1;
		int aux=0;
		while(i<j){
			if(a[i]<0)
				++i;
			else if(a[j]>=0)
				--j;
			else{
				//intercambiar a[i] <--> a[j]
				aux=a[i];
				a[i]=a[j];
				a[j]=aux;
				//------------------------
				++i;
				--j;
			}
		}
		for(i=0;i<n;i++)
			System.out.print(a[i]+", ");
	}
	/* SEGUNDA FORMA
	 * Reordenar los elementos de un arreglo
	 */
	public static void R2(){
		int[]a={1,2,3,-2,0,-4,-5};
		final int n=a.length; // n
		int i=0;
		int j=n-1;
		int aux=0;
		while(i<j){
			while(i<j && a[i]<0)
				++i;
			while(i<j && a[j]>=0)
				--j;
			if(i<j){
				aux=a[i];
				a[i]=a[j];
				a[j]=aux;
				//------------------------
				++i;
				--j;
			}
		}
		for(i=0;i<n;i++)
			System.out.print(a[i]+", ");
	}
	/* TERCERA FORMA
	 * Reordenar los elementos de un arreglo
	 */
	public static void R3(){
		int[]a={1,2,3,-2,0,-4,-5};
		final int n=a.length; // n
		int i=0;
		int aux=0;
		
		for(int j=0;j<n;++j){
			if(a[j]<0){
				aux=a[i];
				a[i]=a[j];
				a[j]=aux;
				++i;
			}
		}
		for(i=0;i<n;i++)
			System.out.print(a[i]+", ");
	}
	/**Enviar parametros tipo valor no cambia el valor original
	public static void intercambiar(int a,int b){
		 int t=a;
		 a=b;
		 b=t;
	}
	*/
}
