package presentacion01E;
/**
 * Prueba la version 2 del cálculo de x elevado a n usando recursividad
 * Veremos que esta implementación es mucho mas optima que la de las actividades.
 */
public class E2_Elevar {
	public static void main(String[]args){
		//elevar
		
		System.out.print("version 1: ") ;v1(3,2);
		System.out.println();
		System.out.print("version 2: ") ;v2(3,2);
	}
	public static void v1(int x, int n){
		int y=1;
		int z=x;
		for(int j=n;j>0;--j){
			y=y*z;
		}
		System.out.println(y);
	}
	public static void v2(int x, int n){
		int y=1;
		int z=x;
		for(int j=n;j>0;--j){
			while(j%2==0){
				z=z*z;
				j=j/2;
			}
			y=y*z;
		}
		System.out.println(y);
	}
	/**
	 *Recursividad para el metodo elevar version 1
	 */
	public static float v1R(float x,int n){
		if(n==0)// primer if caso base
			return 1;
		else
			return x*v1R(x,n-1);//sacamos una copia de la función
	}
	/**
	 *Recursividad para el metodo elevar version 2 optimizada
	 */
	public static float v2R(float x, int n){
		if(n==0)
			return 1;
		else if(n%2!=0)
			return x*v2R(x,n-1);
		else
			return v2R(x*x,n/2);
	}
}
