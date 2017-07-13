package presentacion01E;

public class Par {
	protected double a,b; //mejor protected para usar en clases extendidas.
	
	public Par(double x, double y){
		a=x;
		b=y;
	}
	public Par(){
		a=b=0;
	}
	public Par(Par x){
		a=x.a;
		b=x.b;
	}
	
	public double primero(){
		return a;
	}
	public double segundo(){
		return b;
	}
	public boolean equals(Par x){
		return a==x.a&&b==x.b;
	}
	
	public String toString(){
		return "("+a+" , "+b+")";
	}
	
	public void primero(double x){
		a=x;
	}
	public void asignar(Par x){
		this.a=x.a;
		this.b=x.b;
	}
	
}
