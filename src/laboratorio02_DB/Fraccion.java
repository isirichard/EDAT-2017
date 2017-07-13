package laboratorio02_DB;

public class Fraccion implements Comparable{
	protected int a, b; //numerador y denominador
	//...
	//compareTo devuelve Nº <, = o > 0
	public int compareTo(Fraccion x){
		return a*x.b - b*x.a; 
	}
	public boolean equals(Fraccion x){ return a*x.b==b*x.a; }
	//...
	@Override
	public int compareTo(Object x) {
		// TODO Auto-generated method stub
		return 0;
	}
}