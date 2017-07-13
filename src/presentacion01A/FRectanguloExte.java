package presentacion01A;

public class FRectanguloExte extends AFigura {
	private double largo;
	private double ancho;
	public FRectanguloExte (double l, double a){
		super("rectangulo");
		largo=l;
		ancho=a;
	}
	@Override
	public double area(){
		return largo*ancho;
	}
}
