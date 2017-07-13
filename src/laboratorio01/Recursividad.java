package laboratorio01;

public class Recursividad {
	public static void main(String[]args){
		int x=4;
		int n=2;
		float res = elevar(x,n);
		System.out.println("El valor de " +x +" a la "+n+" es "+res);
	}
	
	public static float elevar(float x, int n){
		if(n==0)
			return 1;
		else
			return x*elevar(x,n-1);
	}
}
