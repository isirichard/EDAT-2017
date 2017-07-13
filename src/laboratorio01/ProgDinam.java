package laboratorio01;

public class ProgDinam {
	public static void main(String[]args){
		System.out.println(F2(8));
		//System.out.println(F2(12));
		
	}
	//solución recursiva FIBONACCI
	public static int F(int n){
		
		if(n<=1){
			//System.out.println(n +"==> fin ");
			return n;
		}
		else{
			//System.out.print(n+ "==> ");
			return F(n-1)+F(n-2);
		}
	}
	//Versión de programación dinámica FIBONACCI es
	//usando arreglos
	public static int F2(int n){
		int[]fib=new int[n+1];
		fib[0]=0;
		fib[1]=1;
		for(int j=2;j<=n;++j)
			fib[j]=fib[j-1]+fib[j-2];
		int resp=fib[n];
		return resp;
	}
}
