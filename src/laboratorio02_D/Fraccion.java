package laboratorio02_D;

public class Fraccion {

	protected int a;
	protected int b; //numerador y denominador
	//...
	//compareTo devuelve Nº <, = o > 0
	public int compareTo(Fraccion x){
		return a*x.b - b*x.a;
	}
	public boolean equals(Fraccion x){
		return a*x.b==b*x.a;
	}
	//...
}
