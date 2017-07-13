package presentacion01E;

abstract class APar {
	protected int a,b;
	public APar(int x, int y){
		a=x;
		b=y;
	}
	public int primero(){
		return a;
	}
	public int segundo(){
		return b;
	}
	abstract public String toSgtring();
}
