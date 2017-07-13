package presentacion01E;

public class PTernaExte extends Par {
	protected double c;
	public PTernaExte(double x,double y, double z){
		super(x,y);
		c=z;
	}
	public PTernaExte(){
		super();
		c=0;
	}
	public PTernaExte(PTernaExte x){
		super(x);
		c=x.c;
	}
	
	public double tercero(){
		return c;
	}
	
	public void tercero(double x){
		c=x;
	}
	public void asignar(PTernaExte x){
		super.asignar(x);
		c=x.c;
	}
	
	public boolean equals(PTernaExte x){
		return super.equals(x)&&c==x.c;
	}
	/**
	 * para usar las variables a b de la superclase
	 * debe ser declaradas en protected y no private.
	 */
	public String toString(){
		return "("+a+","+b+","+c+")";
	}
}
