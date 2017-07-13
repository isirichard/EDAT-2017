package presentacion01E;

public class E3_Hanoi {
	/**
	 * Implementa las Torres de HANOI usando recursividad
	 */
	public static void main(String[]args){
		//torre de hanoi
		Hanoi(3,1,2,3);
	}
	public static void Hanoi(int n, int a, int b, int c){
		if(n>0){
			Hanoi(n-1,a,c,b);
			System.out.println(a+"==>"+c);
			Hanoi(n-1,b,a,c);
		}
	}
}
