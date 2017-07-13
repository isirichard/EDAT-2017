package presentacion01A;

abstract class AFigura {
	private String nombre;
	abstract public double area();
	
	public AFigura(String n){
		nombre=n;
	}
	//Este constructor no puede ser invocado directamente,
	//sólo lo usan las clases derivadas
	
	final public double compArea(AFigura b){
		return area()-b.area();
	}
}
